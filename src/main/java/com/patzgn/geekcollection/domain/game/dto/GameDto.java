package com.patzgn.geekcollection.domain.game.dto;

public class GameDto {
    private Long id;
    private String title;
    private String platform;
    private String publisher;
    private Integer releaseYear;
    private String description;
    private String poster;

    public GameDto(Long id, String title, String platform, String publisher, Integer releaseYear, String description, String poster) {
        this.id = id;
        this.title = title;
        this.platform = platform;
        this.publisher = publisher;
        this.releaseYear = releaseYear;
        this.description = description;
        this.poster = poster;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
