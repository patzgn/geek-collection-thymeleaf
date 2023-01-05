package com.patzgn.geekcollection.domain.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationDto {

    private String email;
    private String name;
    private String password;

}
