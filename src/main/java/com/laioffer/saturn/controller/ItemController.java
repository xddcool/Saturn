package com.laioffer.saturn.controller;

import com.laioffer.saturn.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class ItemController {
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @DeleteMapping("/items/{itemId}")
    public void deleteItem(@PathVariable Long itemId, Principal principal) {
        itemService.delete(itemId, principal.getName());
    }
}
