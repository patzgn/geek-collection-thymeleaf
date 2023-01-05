package com.patzgn.geekcollection.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public class UserCredentialsDto {
    private final String name;
    private final String password;
    private final Set<String> roles;

}
