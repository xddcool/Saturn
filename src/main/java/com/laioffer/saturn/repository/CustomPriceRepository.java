package com.laioffer.saturn.repository;

import com.laioffer.saturn.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CustomPriceRepository extends JpaRepository<Item, Long> {
    @Query(value = "SELECT i.id From Item i WHERE i.price >= ?1 and i.price <= ?2")
    List<Long> findIdByPrice(Double priceMin, Double priceMax);
}