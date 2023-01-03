package com.patzgn.geekcollection.domain.game.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class GameDto {

    private Long id;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    private String description;
    private String poster;
    private Set<String> platforms;
    private Set<String> genres;

}
