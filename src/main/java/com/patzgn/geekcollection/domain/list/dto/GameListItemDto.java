package com.patzgn.geekcollection.domain.list.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GameListItemDto {

    private Long id;
    private String status;
    private String game;

}
