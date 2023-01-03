package com.patzgn.geekcollection.domain.genre;

import com.patzgn.geekcollection.domain.genre.dto.GenreDto;

public class GenreDtoMapper {
    static GenreDto map(Genre genre) {
        return new GenreDto(
                genre.getId(),
                genre.getName()
        );
    }
}
