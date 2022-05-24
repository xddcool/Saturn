package com.laioffer.saturn.service;

import com.laioffer.saturn.exception.ItemNotExistException;
import com.laioffer.saturn.model.Favorite;
import com.laioffer.saturn.model.Item;
import com.laioffer.saturn.model.User;
import com.laioffer.saturn.repository.FavoriteRepository;
import com.laioffer.saturn.repository.ItemRepository;
import com.laioffer.saturn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

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

        Item item = itemRepository.findItemById(itemId);
        if (item == null) {
            throw new ItemNotExistException("No such item in the database");
        }
        Favorite favoriteItem = new Favorite.Builder().setItem(item)
                        .setUsername(principal.getName())
                                .build();

        favoriteRepository.save(favoriteItem);
    }

    public void deleteFavoriteItem(Long itemId, Principal principal) {

        Favorite favorite = favoriteRepository.findFavoriteByUsernameAndItemId(principal.getName(),itemId);
        if (favorite == null) {
            throw new ItemNotExistException("No such item in the database");
        }
        favoriteRepository.deleteById(favorite.getId());
    }

    public List<Item> getFavoriteItem(Principal principal) {
//        List<Long> itemIds = favoriteRepository.findItemIdByUsername(principal.getName());
//        List<Item> items = new ArrayList<>();
//
//        for (Long ids : itemIds) {
//            items.add(itemRepository.findItemById(ids));
//
//
//        }
        List<Item> items = favoriteRepository.findItemByUsername(principal.getName());
        return items;
    }


}
