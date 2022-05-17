package com.laioffer.saturn.repository;

import com.laioffer.saturn.model.Ask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AskRepository extends JpaRepository<Ask, Long> {
    Ask findAskByItemIdAndAskBy(Long itemId, String askBy);
}
