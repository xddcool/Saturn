package com.laioffer.saturn.controller;

import com.laioffer.saturn.model.Favorite;
import com.laioffer.saturn.model.Item;
import com.laioffer.saturn.model.Status;
import com.laioffer.saturn.model.User;
import com.laioffer.saturn.service.FavoriteService;
import com.laioffer.saturn.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

        favoriteService.setFavoriteItem(itemId, principal);
    }

    @DeleteMapping("/favorite/{itemId}")
    public void deleteFavoriteItem(
            @PathVariable Long itemId,
            Principal principal) {

        favoriteService.deleteFavoriteItem(itemId, principal);
    }

}
