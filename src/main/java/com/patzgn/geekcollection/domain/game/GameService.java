package com.patzgn.geekcollection.domain.game;

import org.springframework.stereotype.Service;

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

}
