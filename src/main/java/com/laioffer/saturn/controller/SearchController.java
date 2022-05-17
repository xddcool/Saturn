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

    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping(value = "/search")

    public List<Item> searchItem(
        @RequestParam(name = "itemName", required = false) String itemName,
        @RequestParam(name = "itemDesc", required = false) String itemDesc,
        //@RequestParam(name = "sellerName") String sellerName,
        //@RequestParam(name = "location") String loc,
        //@RequestParam(name = "rating") int rating,
        @RequestParam(name = "priceMin", required = false) Double priceMin,
        @RequestParam(name = "priceMax", required = false) Double priceMax){
        //@RequestParam(name = "category") String category,


        return searchService.search(itemName,itemDesc, priceMin, priceMax);
    }



}
