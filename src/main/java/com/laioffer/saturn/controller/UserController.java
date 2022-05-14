package com.laioffer.saturn.controller;

import com.laioffer.saturn.model.Item;
import com.laioffer.saturn.model.Status;
import com.laioffer.saturn.model.User;
import com.laioffer.saturn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user")
    public User getUser(Principal principal) {
        return userService.getUser(principal.getName());
    }

    @PutMapping(value = "/user")
    public void updateUser(@RequestParam("email") String email, @RequestParam("phone_number") String phone_number, Principal principal) {
        User user = new User.Builder()
                .setUsername("place_holder")
                .setPassword("place_holder")
                        .setEmail(email)
                        .setPhoneNumber(phone_number)
                        .build();

        userService.updateUser(user, principal);
    }

}
