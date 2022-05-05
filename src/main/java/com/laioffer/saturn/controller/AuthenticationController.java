package com.laioffer.saturn.controller;

import com.laioffer.saturn.model.Item;
import com.laioffer.saturn.model.Token;
import com.laioffer.saturn.service.AuthenticationService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class AuthenticationController {
    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/authenticate/guest")
    public Token authenticateGuest(@RequestBody Item item) {
        return authenticationService.authenticate(item, UserRole.ROLE_GUEST);
    }

    @PostMapping("/authenticate/host")
    public Token authenticateHost(@RequestBody Item item) {
        return authenticationService.authenticate(item, UserRole.ROLE_HOST);
    }
}

