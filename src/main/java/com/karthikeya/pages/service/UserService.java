package com.karthikeya.pages.service;

import com.karthikeya.pages.dto.request.UserRegisterDTO;
import com.karthikeya.pages.entity.User;
import com.karthikeya.pages.exception.UserAlreadyExistsException;
import com.karthikeya.pages.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(@Valid UserRegisterDTO dto) {

        validatePasswords(dto.getPassword(), dto.getConfirmPassword());

        checkExistingUser(dto.getEmail(), dto.getUsername());

        User user = User.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .build();

        userRepository.save(user);
    }

    private void validatePasswords(String password, String confirmPassword) {
        if (!password.equals(confirmPassword))
            throw new IllegalArgumentException("Passwords do not match");
    }

    private void checkExistingUser(String email, String userName) {
        if (userRepository.existsUserByEmail(email))
            throw new UserAlreadyExistsException("user with email : " + email + " already exists");
        if (userRepository.existsUserByUsername(userName))
            throw new UserAlreadyExistsException("user with username : " + userName + " already exists");
    }
}

