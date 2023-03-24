package com.patzgn.geekcollection.domain.user;

import com.patzgn.geekcollection.domain.usergame.UserGameDto;
import com.patzgn.geekcollection.domain.user.dto.UserCredentialsDto;
import com.patzgn.geekcollection.domain.user.dto.UserRegistrationDto;
import com.patzgn.geekcollection.domain.usergame.UserGameMapper;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private static final String DEFAULT_USER_ROLE = "USER";
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<UserCredentialsDto> findCredentialsByName(String name) {
        return userRepository.findByName(name)
                .map(UserCredentialsDtoMapper::map);
    }

    @Transactional
    public void registerUserWithDefaultRole(UserRegistrationDto userRegistration) {
        UserRole defaultRole = userRoleRepository.findByName(DEFAULT_USER_ROLE).orElseThrow();
        User user = new User();
        user.setEmail(userRegistration.getEmail());
        user.setName(userRegistration.getName());
        user.setPassword(passwordEncoder.encode(userRegistration.getPassword()));
        user.getRoles().add(defaultRole);
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(String username) {
        userRepository.deleteByName(username);
    }

    public List<UserGameDto> getAllUserGames(String username) {
        return userRepository.findByName(username)
                .map(User::getGames)
                .orElseThrow()
                .stream()
                .map(UserGameMapper::toDto)
                .collect(Collectors.toList());
    }

}
