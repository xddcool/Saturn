package com.laioffer.saturn.service;

import com.laioffer.saturn.model.Item;
import com.laioffer.saturn.model.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import com.laioffer.saturn.exception.ItemNotExistException;
import com.laioffer.saturn.repository.ItemRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class ItemService {
    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(Long itemId, String username) throws ItemNotExistException {

        // this api is for seller to delete his item
        Item item = itemRepository.findByIdAndUser(itemId, new User.Builder().setUsername(username).build());

        if (item == null) {
            throw new ItemNotExistException("Item doesn't exist");
        }

        else {
            itemRepository.deleteById(itemId);
        }
    }
}
