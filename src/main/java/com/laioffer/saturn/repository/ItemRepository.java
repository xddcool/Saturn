package com.laioffer.saturn.repository;

import com.laioffer.saturn.model.Item;
import com.laioffer.saturn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findItemByName(String name);

    // find the item by the item's id and user (buyer)
    Item findByIdAndUser(Long id, User user);
    // Item findById(Long id, User user);
}
