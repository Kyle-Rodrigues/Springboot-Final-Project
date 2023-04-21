package com.example.clothes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clothes.model.Item;
import com.example.clothes.model.Item.Brand;

public interface ItemRepository extends JpaRepository<Item, Long>{
    
    List<Item> findByBrandAndYearCreated(Brand brand, int yearCreated);
}
