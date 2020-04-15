package com.in28minutes.unittesting.controller;


import com.in28minutes.unittesting.model.Item;
import com.in28minutes.unittesting.service.ItemBusinessService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService itemBusinessService;

    @Test
     public void itemCOntrollerTest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();
    }


    @Test
    public void getItemFromBusinessServiceTest() throws Exception {
        when(itemBusinessService.retrieveHardCodedValues()).thenReturn(new Item(2,"Apple",20,200));

        RequestBuilder request = MockMvcRequestBuilders.get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:2,name:Apple,price:20,quantity:200}"))
                .andReturn();
    }

    @Test
    public void retrieveAllItems_basicTest() throws Exception {
        when(itemBusinessService.retrieveAllItems()).thenReturn(
                Arrays.asList(new Item(1001,"Item1",10,200),
                        new Item(1002,"Item2",10,300))
                );

        RequestBuilder request = MockMvcRequestBuilders.get("/all-items")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:1001,name:Item1,price:10,quantity:200},{id:1002,name:Item2,price:10,quantity:300}]"))
                .andReturn();
    }

}
