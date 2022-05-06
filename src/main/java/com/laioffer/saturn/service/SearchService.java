package com.laioffer.saturn.service;


import com.laioffer.saturn.model.Item;
import com.laioffer.saturn.repository.ItemRepository;
import com.laioffer.saturn.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    private ItemRepository itemRepository;
    private PriceRepository priceRepository;

    //declare fields
    //constructors
    @Autowired
    public SearchService(ItemRepository itemRepository, PriceRepository priceRepository) {
        this.itemRepository = itemRepository;
        this.priceRepository = priceRepository;
    }
    public List<Item> search(String name, String description, Double priceMin, Double priceMax) {
        if (priceMin == null) {
            priceMin = 0.0;
        }

        if (priceMax == null) {
            priceMax = Double.MAX_VALUE;
        }

            return priceRepository.findItemsByPriceBetween(priceMin, priceMax);


        //return itemRepository.findItemByName(name);
    }
}
