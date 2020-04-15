package com.in28minutes.unittesting.business;


import com.in28minutes.unittesting.model.Item;
import com.in28minutes.unittesting.repository.ItemRepository;
import com.in28minutes.unittesting.service.ItemBusinessService;
import com.in28minutes.unittesting.service.ItemBusinessServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemBusinessServiceImpl itemBusinessService;

    @Test
    public void retrieveAllItemsTest(){
        when(itemRepository.findAll()).thenReturn(Arrays.asList(new Item(1001,"Item1",10,200),
                new Item(1002,"Item2",10,300)));

        List<Item> items = itemBusinessService.retrieveAllItems();

        assertEquals(2000, items.get(0).getValue());
        assertEquals(3000, items.get(1).getValue());
    }

}
