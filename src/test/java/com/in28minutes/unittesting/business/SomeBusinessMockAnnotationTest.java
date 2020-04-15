package com.in28minutes.unittesting.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomeBusinessMockAnnotationTest {

    private SomeBusinessImpl business = new SomeBusinessImpl();
    private DataService dataService = mock(DataService.class);

    @BeforeEach
    public void before(){
        business.setIDataService(dataService);
    }

    @Test
    public void calculateSumUsingDataService_basicTest(){

        when(dataService.retreiveData()).thenReturn(new int[]{1,2,3});
        assertEquals(business.calculateSumUsingDataService(), 6);
    }

    @Test
    public void calculateSumUsingDataService_Empty(){

        when(dataService.retreiveData()).thenReturn(new int[]{});
        assertEquals(business.calculateSumUsingDataService(), 0);
    }

    @Test
    public void calculateSum_OneValue(){

        when(dataService.retreiveData()).thenReturn(new int[]{5});
        assertEquals(business.calculateSumUsingDataService(), 5);
    }
}
