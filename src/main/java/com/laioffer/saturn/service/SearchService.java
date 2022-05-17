package com.laioffer.saturn.service;


import com.laioffer.saturn.exception.InvalidSearchPriceException;
import com.laioffer.saturn.model.Item;
import com.laioffer.saturn.repository.CustomNameRepository;
import com.laioffer.saturn.repository.CustomPriceRepository;
import com.laioffer.saturn.repository.ItemRepository;
import com.laioffer.saturn.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class SearchService {
    private final ItemRepository itemRepository;
    private final PriceRepository priceRepository;
    private final CustomNameRepository customNameRepository;
    private final CustomPriceRepository customPriceRepository;

    //declare fields
    //constructors
    @Autowired
    public SearchService(ItemRepository itemRepository, PriceRepository priceRepository, CustomNameRepository customNameRepository, CustomPriceRepository customPriceRepository) {
        this.itemRepository = itemRepository;
        this.priceRepository = priceRepository;
        this.customNameRepository = customNameRepository;
        this.customPriceRepository = customPriceRepository;
    }
    public List<Item> search(String name, String description, Double priceMin, Double priceMax) throws InvalidSearchPriceException {

        if (priceMin != null && priceMax != null && priceMin > priceMax) {
            throw new InvalidSearchPriceException("Price min must be lower or equal to price max!");
        }

        if (priceMin == null) {
            priceMin = 0.0;
        }

        if (priceMax == null) {
            priceMax = Double.MAX_VALUE;
        }

        List<Item> itemByPrice = priceRepository.findItemsByPriceBetween(priceMin, priceMax);
        //Long itemIdByName = customNameRepository.findItemIdContainsName(name);

//        Long itemIdsByName = customNameRepository.findItemIdContainsName(name);
//
//        List<Item> itemByName = itemRepository.findItemsById(itemIdsByName);


        //List<Item> itemByName = itemRepository.findItemByNameContaining(name);
        List<Item> itemByName = new ArrayList<>();
        List<Long> itemByNameId =customNameRepository.findItem(name);
        for (Long itemId: itemByNameId) {
            itemByName.add(itemRepository.findItemById(itemId));
        }

//        List<Long> idByPrice = customPriceRepository.findIdByPrice(priceMin, priceMax);
//        List<Long> idByName = customNameRepository.findIdByName(name);
//
//        List<Long> filteredItemIds = new ArrayList<>();
//        for (Long itemId: idByPrice) {
//            if (idByName.contains(itemId)) {
//                filteredItemIds.add(itemId);
//            }
//        }
//
        List<Item> filteredItem = new ArrayList<>();

        for (Item item : itemByPrice) {
            if (itemByName.contains(item)) {
                filteredItem.add(item);
            }
        }

        return filteredItem;
        //return priceRepository.findItemsByPriceBetween(priceMin, priceMax);


    }
}
