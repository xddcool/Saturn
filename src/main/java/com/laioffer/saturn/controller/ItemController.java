package com.laioffer.saturn.controller;

import com.laioffer.saturn.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    //Item add mapping

    //Item get mapping

    //Item edit mapping

    //Item delete mapping

}
