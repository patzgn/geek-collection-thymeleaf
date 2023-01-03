package com.patzgn.geekcollection.domain.game;

import com.patzgn.geekcollection.domain.game.dto.GameDto;
import com.patzgn.geekcollection.domain.game.dto.GameSaveDto;
import com.patzgn.geekcollection.domain.genre.Genre;
import com.patzgn.geekcollection.domain.genre.GenreRepository;
import com.patzgn.geekcollection.domain.platform.Platform;
import com.patzgn.geekcollection.domain.platform.PlatformRepository;
import com.patzgn.geekcollection.storage.FileStorageService;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final PlatformRepository platformRepository;
    private final GenreRepository genreRepository;
    private final FileStorageService fileStorageService;

    public GameService(GameRepository gameRepository, PlatformRepository platformRepository, GenreRepository genreRepository, FileStorageService fileStorageService) {
        this.gameRepository = gameRepository;
        this.platformRepository = platformRepository;
        this.genreRepository = genreRepository;
        this.fileStorageService = fileStorageService;
    }

    public Optional<GameDto> findGameById(long id) {
        return gameRepository.findById(id).map(GameDtoMapper::map);
    }

    public List<GameDto> findAllGames() {
        return StreamSupport.stream(gameRepository.findAll().spliterator(), false)
                .map(GameDtoMapper::map)
                .toList();
    }

    public Page<GameDto> findAllGamesPage(int page, int size) {
        Sort.Order order = new Sort.Order(Sort.Direction.ASC, "title");
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by(order));
        return gameRepository.findAll(pageable)
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

}
