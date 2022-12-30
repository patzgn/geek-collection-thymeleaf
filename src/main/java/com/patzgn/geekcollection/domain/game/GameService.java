package com.patzgn.geekcollection.domain.game;

import com.patzgn.geekcollection.domain.game.dto.GameDto;
import com.patzgn.geekcollection.domain.game.dto.GameSaveDto;
import com.patzgn.geekcollection.storage.FileStorageService;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final FileStorageService fileStorageService;

    public GameService(GameRepository gameRepository, FileStorageService fileStorageService) {
        this.gameRepository = gameRepository;
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
        game.setPlatform(gameToSave.getPlatform());
        game.setPublisher(gameToSave.getPublisher());
        game.setReleaseYear(gameToSave.getReleaseYear());
        game.setDescription(gameToSave.getDescription());
        if (gameToSave.getPoster() != null) {
            String savedFileName = fileStorageService.saveImage(gameToSave.getPoster());
            game.setPoster(savedFileName);
        }
        gameRepository.save(game);
    }

}
