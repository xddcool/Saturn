package com.laioffer.saturn.service;

import com.laioffer.saturn.exception.ItemNotExistException;
import com.laioffer.saturn.exception.UserAlreadyExistException;
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
    public void edit(Item item, Long id) throws ItemNotExistException {
        if (!itemRepository.existsById(id)) {
            throw new ItemNotExistException("No such item in the database");
        }

        Item oldItem = itemRepository.getById(id);
        oldItem.setPrice(item.getPrice());
        oldItem.setDescription(item.getDescription());
        oldItem.setName(item.getName());
        itemRepository.save(oldItem);

    }

    //Item delete
}
