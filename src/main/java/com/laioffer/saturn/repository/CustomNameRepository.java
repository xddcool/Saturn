package com.laioffer.saturn.repository;

import com.laioffer.saturn.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CustomNameRepository extends JpaRepository<Item, Long> {
    @Query(value = "SELECT i.id From Item i WHERE i.name like %?1%")
    List<Long> findItemByName(String name);

    @Query(value = "SELECT i.id From Item i WHERE i.description like %?1%")
    List<Long> findItemByDesc(String name);
}
