package com.karthikeya.pages.controller;

import com.karthikeya.pages.dto.request.UserRegisterDTO;
import com.karthikeya.pages.dto.response.ApiResponse;
import com.karthikeya.pages.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<?>> registerUser(
            @Valid @RequestBody UserRegisterDTO dto
    ) {
        System.out.println(dto);
        userService.registerUser(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success("Registration Successful"));
    }

}
