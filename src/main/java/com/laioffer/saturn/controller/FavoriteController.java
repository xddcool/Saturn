package com.laioffer.saturn.controller;

import com.laioffer.saturn.model.Favorite;
import com.laioffer.saturn.model.Item;
import com.laioffer.saturn.model.Status;
import com.laioffer.saturn.service.FavoriteService;
import com.laioffer.saturn.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@RestController
public class FavoriteController {
    private FavoriteService favoriteService;

    @Autowired
    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PostMapping("/favorite/{itemId}")
    public void addFavoriteItem(
            @PathVariable Long itemId,
            Principal principal) {

        Favorite favoriteItem = new Favorite.Builder().setUsername(principal.getName())
                .setItemId(itemId)
                .build();
        System.out.println("here");
        favoriteService.setFavoriteItem(favoriteItem);
    }

}
