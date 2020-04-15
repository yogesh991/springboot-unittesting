package com.in28minutes.unittesting.service;

import com.in28minutes.unittesting.model.Item;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ItemBusinessService {
    public Item retrieveHardCodedValues();

    public List<Item> retrieveAllItems();
}
