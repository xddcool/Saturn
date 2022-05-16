package com.laioffer.saturn.repository;

import com.laioffer.saturn.model.Favorite;
import com.laioffer.saturn.model.Item;
import com.laioffer.saturn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
        Favorite findFavoriteByUsernameAndItemId(String username, Long itemId);
        }
