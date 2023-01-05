package com.patzgn.geekcollection.domain.list.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class GameListDto {

    private Long id;
    private String name;
    private Set<String> games;

}
