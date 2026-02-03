package com.karthikeya.pages.controller;

import com.karthikeya.pages.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody User user) {

    }
}
