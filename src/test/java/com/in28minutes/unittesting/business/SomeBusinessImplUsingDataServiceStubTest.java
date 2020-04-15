package com.in28minutes.unittesting.business;

import com.in28minutes.unittesting.service.IDataService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DataService implements IDataService{

    @Override
    public int[] retreiveData() {
        return new int[]{1,2,3};
    }
}

class DataServiceEmpty implements IDataService{

    @Override
    public int[] retreiveData() {
        return new int[]{};
    }
}

class DataServiceOneValue implements IDataService {

    @Override
    public int[] retreiveData() {
        return new int[]{5};
    }
}

class SomeBusinessImplUsingDataServiceTest {

    @Test
    public void calculateSumUsingDataService_basicTest(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setIDataService(new DataService());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(actualResult,expectedResult);
    }

    @Test
    public void calculateSumUsingDataService_Empty(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setIDataService(new DataServiceEmpty());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(actualResult,expectedResult);
    }

    @Test
    public void calculateSum_OneValue(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setIDataService(new DataServiceOneValue());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 5;
        assertEquals(actualResult,expectedResult);
    }

}
