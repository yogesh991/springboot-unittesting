package com.in28minutes.unittesting.controller;

import com.in28minutes.unittesting.model.Item;
import com.in28minutes.unittesting.service.ItemBusinessService;
import com.in28minutes.unittesting.service.ItemBusinessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemBusinessService itemBusinessService;

    @GetMapping("/item")
    public Item getDummyObject(){
        return new Item(1,"Ball",10,100);
    }


    @GetMapping("/item-from-business-service")
    public Item getItemFromBusinessService(){
        return itemBusinessService.retrieveHardCodedValues();
    }

    @GetMapping("/all-items")
    public List<Item> retrieveAllItems(){
        return itemBusinessService.retrieveAllItems();
    }
}
