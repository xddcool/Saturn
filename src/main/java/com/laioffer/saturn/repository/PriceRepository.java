package com.laioffer.saturn.repository;

import com.laioffer.saturn.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Item, Long> {

    List<Item> findItemsByPriceBetween(double priceMin, double priceMax);
}
