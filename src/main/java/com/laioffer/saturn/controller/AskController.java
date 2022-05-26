package com.laioffer.saturn.controller;

import com.laioffer.saturn.model.Ask;
import com.laioffer.saturn.model.Item;
import com.laioffer.saturn.service.AskService;
import com.laioffer.saturn.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class AskController {
    private AskService askService;

    @Autowired
    public AskController(AskService askService) {
        this.askService = askService;
    }

    @GetMapping(value = "/asks")
    public List<Item> listAsks(Principal principal) {
        return askService.get(principal);
    }

    @DeleteMapping("/asks/{askId}")
    public void deleteItem(@PathVariable Long askId, Principal principal) {
        askService.delete(askId, principal);
    }
}
