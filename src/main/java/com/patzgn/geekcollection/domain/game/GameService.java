package com.patzgn.geekcollection.domain.game;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
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

}
