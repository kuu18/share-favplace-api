package com.pandaman.sharefavplaceapi.controller;

import com.pandaman.sharefavplaceapi.entity.User;
import com.pandaman.sharefavplaceapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("users")
    public List<User> getUsers() {
        return userService.findAll();
    }
}
