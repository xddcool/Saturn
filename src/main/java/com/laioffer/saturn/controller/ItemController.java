package com.laioffer.saturn.controller;

import com.laioffer.saturn.model.Item;
import com.laioffer.saturn.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    //Item add mapping

    //Item get mapping

    //Item edit mapping
    @PutMapping(value = "/edit/{itemId}")
    public void editItem(
            @PathVariable Long itemId,
            @RequestParam("itemName") String name,
            @RequestParam("itemDesc") String description,
            @RequestParam("itemPrice") Double price,
            Principal principal) {

        Item item = new Item.Builder().setId(itemId)
                .setDescription(description)
                .setName(name)
                .setPrice(price)
                .build();

        itemService.edit(item);
    }



    //Item delete mapping

}
