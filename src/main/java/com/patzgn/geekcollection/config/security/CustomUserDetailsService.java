package com.patzgn.geekcollection.config.security;

import com.patzgn.geekcollection.domain.user.UserService;
import com.patzgn.geekcollection.domain.user.dto.UserCredentialsDto;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userService.findCredentialsByName(username)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with name %s not found", username)));
    }

    private UserDetails createUserDetails(UserCredentialsDto credentials) {
        return User.builder()
                .username(credentials.getName())
                .password(credentials.getPassword())
                .roles(credentials.getRoles().toArray(String[]::new))
                .build();
    }
}
