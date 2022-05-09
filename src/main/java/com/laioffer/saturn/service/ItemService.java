package com.laioffer.saturn.service;

import com.laioffer.saturn.model.Item;
import com.laioffer.saturn.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemService {
    private ItemRepository itemRepository;


    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    //Item add


    //Item get

    //Item edit
    public void edit(Item item/*, Long id*/) {
        //itemRepository.deleteById(id);
        itemRepository.save(item);
    }

    //Item delete
}
