package com.laioffer.saturn.service;


import com.laioffer.saturn.model.Item;
import com.laioffer.saturn.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    private ItemRepository itemRepository;

    //declare fields
    //constructors
    @Autowired
    public SearchService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    public List<Item> search(String name, String description, double priceMin, double priceMax) {
        //corner case check

        //main logic

//        for (Long stayId : stayIds) {
//            if (!reservedStayIds.contains(stayId)) {
//                filteredStayIds.add(stayId);
//            }
//        }
//            List<Item> test = new ArrayList<>();
//            Item testItem = new Item();
//            testItem.setName("Computer");
//            testItem.setDescription("This is my computer");
//            testItem.setPrice(1.1);
//            test.add(testItem);
//            return test;

        List<Long> itemIds = new ArrayList<>();
        itemIds.add(1L);
        itemIds.add(2L);

        return itemRepository.findById(itemIds);
    }
}
