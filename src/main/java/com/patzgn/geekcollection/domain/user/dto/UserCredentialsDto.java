package com.patzgn.geekcollection.domain.user.dto;

import java.util.Set;

public class UserCredentialsDto {
    private final String name;
    private final String password;
    private final Set<String> roles;

    public UserCredentialsDto(String name, String password, Set<String> roles) {
        this.name = name;
        this.password = password;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Set<String> getRoles() {
        return roles;
    }
}
