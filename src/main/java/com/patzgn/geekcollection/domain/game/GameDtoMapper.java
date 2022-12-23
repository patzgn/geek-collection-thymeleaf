package com.patzgn.geekcollection.domain.game;

public class GameDtoMapper {

    static GameDto map(Game game) {
        return new GameDto(
                game.getId(),
                game.getTitle(),
                game.getReleaseYear(),
                game.getDescription(),
                game.getPoster()
        );
    }
}
