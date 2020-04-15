package com.in28minutes.unittesting.repository;

import com.in28minutes.unittesting.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
