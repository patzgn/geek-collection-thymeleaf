package com.patzgn.geekcollection.domain.game.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@Getter
@Setter
public class GameSaveDto {

    private String title;
    private String releaseDate;
    private String description;
    private MultipartFile poster;
    private Set<String> platforms;
    private Set<String> genres;

}
