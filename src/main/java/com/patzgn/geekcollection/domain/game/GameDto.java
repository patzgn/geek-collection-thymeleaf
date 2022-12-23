package com.patzgn.geekcollection.domain.game;

public class GameDto {
    private Long id;
    private String title;
    private Integer releaseYear;
    private String description;
    private String poster;

    public GameDto(Long id, String title, Integer releaseYear, String description, String poster) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.description = description;
        this.poster = poster;
    }
}
