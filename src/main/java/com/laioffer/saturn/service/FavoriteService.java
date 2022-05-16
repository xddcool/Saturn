package com.laioffer.saturn.service;

import com.laioffer.saturn.model.Favorite;
import com.laioffer.saturn.model.Item;
import com.laioffer.saturn.model.User;
import com.laioffer.saturn.repository.FavoriteRepository;
import com.laioffer.saturn.repository.ItemRepository;
import com.laioffer.saturn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class FavoriteService {
    private FavoriteRepository favoriteRepository;
    private ItemRepository itemRepository;
    private UserRepository userRepository;

    @Autowired
    public FavoriteService(FavoriteRepository favoriteRepository, ItemRepository itemRepository, UserRepository userRepository) {
        this.favoriteRepository = favoriteRepository;
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    public void setFavoriteItem(Long itemId, Principal principal) {

        Favorite favoriteItem = new Favorite.Builder().setItemId(itemId)
                        .setUsername(principal.getName())
                                .build();

        favoriteRepository.save(favoriteItem);
    }

    public void deleteFavoriteItem(Long itemId, Principal principal) {

        Favorite favorite = favoriteRepository.findFavoriteByUsernameAndItemId(principal.getName(),itemId);

        favoriteRepository.deleteById(favorite.getId());
    }


}
