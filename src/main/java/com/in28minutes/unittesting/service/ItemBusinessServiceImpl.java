package com.in28minutes.unittesting.service;

import com.in28minutes.unittesting.model.Item;
import com.in28minutes.unittesting.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessServiceImpl implements ItemBusinessService{

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> retrieveAllItems(){
        List<Item> items= itemRepository.findAll();
        for(Item item : items){
            item.setValue(item.getPrice() * item.getQuantity());
        }
        return items;
    }

    @Override
    public Item retrieveHardCodedValues(){
        return new Item(1,"Ball",10,100);
    }
}
