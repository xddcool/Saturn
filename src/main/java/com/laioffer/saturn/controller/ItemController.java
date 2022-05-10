package com.laioffer.saturn.controller;


import com.laioffer.saturn.model.Item;
import com.laioffer.saturn.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;

@RestController
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    //Item delete mapping
    @DeleteMapping("/items/{itemId}")
    public void deleteItem(@PathVariable Long itemId) {
        itemService.delete(itemId);
    }

    //Item add mapping

    //Item get mapping

    //Item edit mapping
    @PutMapping(value = "/items/{itemId}")
    public void editItem(
            @PathVariable Long itemId,
            @RequestBody Item item){

        itemService.edit(item, itemId);
    }

}
