package com.laioffer.saturn.repository;

import com.laioffer.saturn.model.Ask;
import com.laioffer.saturn.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AskRepository extends JpaRepository<Ask, Long> {
    Ask findAskByItemIdAndAskBy(Long itemId, String askBy);

    List<Ask> findAskByAskBy(String askBy);

    @Query(value = "SELECT i.item From Ask i WHERE i.askBy = ?1")
    List<Item> findItemByAskBy(String askBy);

    @Query(value = "SELECT i.item From Ask i where i.id = ?1")
    Item findItemByAsk(Long askId);
//    Item item findItemByAsk(Long askId);
    List<Ask> findAskByItem(Item item);
}
