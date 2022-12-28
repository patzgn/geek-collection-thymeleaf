package com.patzgn.geekcollection.domain.game;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Optional<GameDto> findGameById(long id) {
        return gameRepository.findById(id).map(GameDtoMapper::map);
    }

    public List<GameDto> findLatestGames(int size) {
        Pageable page = Pageable.ofSize(size);
        return gameRepository.findLatestById(page).stream()
                .map(GameDtoMapper::map)
                .toList();
    }

}
