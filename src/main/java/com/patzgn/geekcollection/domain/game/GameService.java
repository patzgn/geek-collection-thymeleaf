package com.patzgn.geekcollection.domain.game;

import com.patzgn.geekcollection.domain.game.dto.GameDto;
import com.patzgn.geekcollection.domain.game.dto.GameSaveDto;
import com.patzgn.geekcollection.domain.genre.Genre;
import com.patzgn.geekcollection.domain.genre.GenreRepository;
import com.patzgn.geekcollection.domain.platform.Platform;
import com.patzgn.geekcollection.domain.platform.PlatformRepository;
import com.patzgn.geekcollection.storage.FileStorageService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.data.domain.Sort.*;

@Service
@AllArgsConstructor
public class GameService {
    private final GameRepository gameRepository;
    private final PlatformRepository platformRepository;
    private final GenreRepository genreRepository;
    private final FileStorageService fileStorageService;


    public Optional<GameDto> findGameById(long id) {
        return gameRepository.findById(id).map(GameDtoMapper::map);
    }

    public Page<GameDto> findAllGames(Pageable pageable) {
        return gameRepository.findAll(pageable)
                .map(GameDtoMapper::map);
    }

    public Page<GameDto> findByTitleContaining(String keyword, Pageable pageable) {
        return gameRepository.findByTitleContainingIgnoreCase(keyword, pageable)
                .map(GameDtoMapper::map);
    }

    public Page<GameDto> findAllByPlatform(String platform, Pageable pageable) {
        return gameRepository.findByPlatforms_NameIgnoreCase(platform.replaceAll("-", " "), pageable)
                .map(GameDtoMapper::map);
    }

    public Page<GameDto> findByPlatformAndTitleContaining(String platform, String keyword, Pageable pageable) {
        return gameRepository.findByPlatforms_NameIgnoreCaseAndTitleContainingIgnoreCase(platform, keyword, pageable)
                .map(GameDtoMapper::map);
    }

    public List<GameDto> findLatestGames(int size) {
        Pageable page = Pageable.ofSize(size);
        return gameRepository.findLatestById(page).stream()
                .map(GameDtoMapper::map)
                .toList();
    }

    public void addGame(GameSaveDto gameToSave) {
        Game game = new Game();
        game.setTitle(gameToSave.getTitle());
        game.setReleaseDate(LocalDate.parse(gameToSave.getReleaseDate()));
        game.setDescription(gameToSave.getDescription());
        if (gameToSave.getPoster() != null) {
            String savedFileName = fileStorageService.saveImage(gameToSave.getPoster());
            game.setPoster(savedFileName);
        }
        Set<Platform> platforms = gameToSave.getPlatforms().stream()
                .map(name -> platformRepository.findByNameIgnoreCase(name)
                        .orElseThrow())
                .collect(Collectors.toSet());
        game.setPlatforms(platforms);
        Set<Genre> genres = gameToSave.getGenres().stream()
                .map(name -> genreRepository.findByNameIgnoreCase(name)
                        .orElseThrow())
                .collect(Collectors.toSet());
        game.setGenres(genres);
        gameRepository.save(game);
    }

    public void deleteGame(long id) {
    }

}
