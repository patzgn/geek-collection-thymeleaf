package com.patzgn.geekcollection.domain.list;

import com.patzgn.geekcollection.domain.game.Game;
import com.patzgn.geekcollection.domain.list.dto.GameListDto;

import java.util.stream.Collectors;

class GameListDtoMapper {
    static GameListDto map(GameList list) {
        return new GameListDto(
                list.getId(),
                list.getName(),
                list.getGames().stream()
                        .map(GameListItem::getGame)
                        .map(Game::getTitle)
                        .collect(Collectors.toSet())
        );
    }
}
