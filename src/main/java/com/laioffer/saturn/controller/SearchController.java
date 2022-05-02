package com.laioffer.saturn.controller;
//import libraries

public class SearchController {

    //constructor

    @GetMapping(value = "/search")

    public List<Item> searchItem(
            //@RequestParam(name = "itemName") String itemName,
            //@RequestParam(name = "sellerName") String sellerName,
            //@RequestParam(name = "location") String loc,
            //@RequestParam(name = "rating") int rating,
            //@RequestParam(name = "priceMin") double priceMin,
            //@RequestParam(name = "priceMax") int priceMax,
            //@RequestParam(name = "category") String category,

            //check condition if condition not met throw expection

            return searchService.search(itemName, sellerName, loc, priceMin, priceMax, cateogry);

    )
}
