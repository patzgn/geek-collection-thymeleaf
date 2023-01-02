package com.patzgn.geekcollection.domain.user;

import com.patzgn.geekcollection.domain.user.dto.UserCredentialsDto;

import java.util.Set;
import java.util.stream.Collectors;

class UserCredentialsDtoMapper {
    static UserCredentialsDto map(User user) {
        String name = user.getName();
        String password = user.getPassword();
        Set<String> roles = user.getRoles()
                .stream()
                .map(UserRole::getName)
                .collect(Collectors.toSet());
        return new UserCredentialsDto(name, password, roles);
    }
}
