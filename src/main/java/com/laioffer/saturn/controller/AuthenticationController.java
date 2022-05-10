package com.laioffer.saturn.controller;

import com.laioffer.saturn.model.Token;
import com.laioffer.saturn.model.User;
import com.laioffer.saturn.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/authenticate")
    public Token authenticate(@RequestBody User user) {
        return authenticationService.authenticate(user);
    }


}