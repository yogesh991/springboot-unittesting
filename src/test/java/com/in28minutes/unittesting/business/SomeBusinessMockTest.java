package com.in28minutes.unittesting.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class SomeBusinessMockTest {

    @Test
    public void calculateSumUsingDataService_basicTest(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        DataService dataService = mock(DataService.class);
        when(dataService.retreiveData()).thenReturn(new int[]{1,2,3});

        business.setIDataService(dataService);
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(actualResult,expectedResult);
    }

    @Test
    public void calculateSumUsingDataService_Empty(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        DataService dataService = mock(DataService.class);
        when(dataService.retreiveData()).thenReturn(new int[]{});

        business.setIDataService(dataService);
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(actualResult,expectedResult);
    }

    @Test
    public void calculateSum_OneValue(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        DataService dataService = mock(DataService.class);
        when(dataService.retreiveData()).thenReturn(new int[]{5});

        business.setIDataService(dataService);
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 5;
        assertEquals(actualResult,expectedResult);
    }

}
