package com.laioffer.saturn.service;

import com.laioffer.saturn.model.Item;
import com.laioffer.saturn.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private ItemRepository itemRepository;


    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    //Item add


    //Item get

    //Item edit
    public void edit(Item item, Long id) {
        Item oldItem = itemRepository.getById(id);
        oldItem.setPrice(item.getPrice());
        oldItem.setDescription(item.getDescription());
        oldItem.setName(item.getName());
        itemRepository.save(oldItem);
    }

    //Item delete
}
