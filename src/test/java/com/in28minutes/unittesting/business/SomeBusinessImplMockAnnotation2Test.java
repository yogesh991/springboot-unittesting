package com.in28minutes.unittesting.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessImplMockAnnotation2Test {

    @InjectMocks
    SomeBusinessImpl business;

    @Mock
    DataService dataService;

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
