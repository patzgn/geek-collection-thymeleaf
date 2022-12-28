package com.patzgn.geekcollection.domain.game;

public class GameDtoMapper {
    static GameDto map(Game game) {
        return new GameDto(
                game.getId(),
                game.getTitle(),
                game.getPlatform(),
                game.getPublisher(),
                game.getReleaseYear(),
                game.getDescription(),
                game.getPoster()
        );
    }
}
