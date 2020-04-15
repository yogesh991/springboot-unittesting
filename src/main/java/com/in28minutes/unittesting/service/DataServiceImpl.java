package com.in28minutes.unittesting.service;

public class DataServiceImpl implements IDataService {

    @Override
    public int[] retreiveData() {
        return new int[]{1,2,3};
    }
}
