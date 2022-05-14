package com.laioffer.saturn.service;

import com.laioffer.saturn.model.User;
import com.laioffer.saturn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(String username) {
        return userRepository.findUsersByUsername(username);
    }

    public void updateUser(User user, Principal principal) {
        User newUser = userRepository.findUsersByUsername(principal.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPhoneNumber(user.getPhoneNumber());
        userRepository.save(newUser);
    }
}
