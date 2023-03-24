package com.patzgn.geekcollection.domain.genre;

import com.patzgn.geekcollection.domain.genre.dto.GenreDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/genres")
@AllArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @GetMapping
    List<GenreDto> findAllGenres() {
        return genreService.findAllGenres();
    }

}
