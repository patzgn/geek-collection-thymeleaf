package com.patzgn.geekcollection.domain.usergame;

import com.patzgn.geekcollection.domain.game.Game;

public class UserGameMapper {

    public static UserGameDto toDto(UserGame userGame) {
        UserGameDto dto = new UserGameDto();
        dto.setGameId(userGame.getId());
        if (userGame.getStatus() != null) {
            dto.setStatus(userGame.getStatus().name());
        }
        if (userGame.getPlatform() != null) {
            dto.setPlatform(userGame.getPlatform().getName());
        }
        Game game = userGame.getGame();
        if (game != null) {
            dto.setGameId(game.getId());
            dto.setGameTitle(game.getTitle());
        }

        return dto;
    }

}
