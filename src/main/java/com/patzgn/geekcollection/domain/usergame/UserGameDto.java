package com.patzgn.geekcollection.domain.usergame;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserGameDto {

    private Long id;
    private String status;
    private String platform;
    private Long gameId;
    private String gameTitle;

}
