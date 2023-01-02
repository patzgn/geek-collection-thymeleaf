package com.patzgn.geekcollection.domain.user;

import com.patzgn.geekcollection.domain.user.dto.UserCredentialsDto;
import com.patzgn.geekcollection.domain.user.dto.UserRegistrationDto;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
}
