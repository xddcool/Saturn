package com.laioffer.saturn.controller;
//import libraries

import com.laioffer.saturn.exception.InvalidSearchPriceException;
import com.laioffer.saturn.model.Item;
import com.laioffer.saturn.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    private SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping(value = "/search")

    public List<Item> searchItem(
        @RequestParam(name = "itemName") String itemName,
        @RequestParam(name = "itemDesc") String itemDesc,
        //@RequestParam(name = "sellerName") String sellerName,
        //@RequestParam(name = "location") String loc,
        //@RequestParam(name = "rating") int rating,
        @RequestParam(name = "priceMin") double priceMin,
        @RequestParam(name = "priceMax") double priceMax){
        //@RequestParam(name = "category") String category,

        //check condition if condition not met throw expection
        if (priceMin > priceMax) {
            throw new InvalidSearchPriceException("Price min must be lower or equal to price max!");
        }

        //return searchService.search(itemName, sellerName, loc, priceMin, priceMax, cateogry);
        return searchService.search(itemName,itemDesc, priceMin, priceMax);
    }



}
