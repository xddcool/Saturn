package com.laioffer.saturn.repository;

import com.laioffer.saturn.model.Favorite;
import com.laioffer.saturn.model.Item;
import com.laioffer.saturn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
        Favorite findFavoriteByUsernameAndItemId(String username, Long itemId);

        //Long findItemIdByUsername(String username);

        @Query(value = "SELECT i.itemId From Favorite i WHERE i.username = ?1")
        List<Long> findItemIdByUsername(String name);
        }
