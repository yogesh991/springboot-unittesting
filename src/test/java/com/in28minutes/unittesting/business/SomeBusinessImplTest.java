package com.in28minutes.unittesting.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeBusinessImplTest {

    @Test
    public void calculateSum_basicTest(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[]{1,2,3});
        int expectedResult = 6;
        assertEquals(actualResult,expectedResult);
    }

    @Test
    public void calculateSum_Empty(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[]{});
        int expectedResult = 0;
        assertEquals(actualResult,expectedResult);
    }

    @Test
    public void calculateSum_OneValue(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[]{5});
        int expectedResult = 5;
        assertEquals(actualResult,expectedResult);
    }

}
