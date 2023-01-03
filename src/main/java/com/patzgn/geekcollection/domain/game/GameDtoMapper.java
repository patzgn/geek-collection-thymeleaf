package com.patzgn.geekcollection.domain.game;

import com.patzgn.geekcollection.domain.game.dto.GameDto;
import com.patzgn.geekcollection.domain.genre.Genre;
import com.patzgn.geekcollection.domain.platform.Platform;

import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

class GameDtoMapper {
    static GameDto map(Game game) {
        return new GameDto(
                game.getId(),
                game.getTitle(),
                game.getReleaseDate(),
                game.getDescription(),
                game.getPoster(),
                game.getPlatforms().stream()
                        .map(Platform::getName)
                        .collect(Collectors.toSet()),
                game.getGenres().stream()
                        .map(Genre::getName)
                        .collect(Collectors.toSet())
        );
    }
}
