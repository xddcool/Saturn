package com.laioffer.saturn.controller;


import com.laioffer.saturn.model.Item;
import com.laioffer.saturn.model.User;
import com.laioffer.saturn.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.security.Principal;
import java.util.List;

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

    @PostMapping("/items")
    public void addStay(
            @RequestParam("itemName") String name,
            @RequestParam("itemDesc") String description,
            @RequestParam("itemPrice") Double price) {

        Item item = new Item.Builder().setName(name)
                .setDescription(description)
                .setPrice(price)
                .build();
        itemService.add(item);
    }

    //Item get mapping
    @GetMapping(value = "/items")
    public List<Item> listStays(User user) {
        return itemService.get(user);
    }

    //Item edit mapping
    @PutMapping(value = "/items/{itemId}")
    public void editItem(
            @PathVariable Long itemId,
            @RequestBody Item item,
            Principal principal){

        itemService.edit(item, itemId);
    }

}
