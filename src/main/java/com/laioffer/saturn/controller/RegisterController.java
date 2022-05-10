package com.laioffer.saturn.controller;

import com.laioffer.saturn.model.User;
import com.laioffer.saturn.model.UserRole;
import com.laioffer.saturn.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/register")
    public void addUser(@RequestBody User user) {
        registerService.add(user, UserRole.USER_ROLE);
    }
}
