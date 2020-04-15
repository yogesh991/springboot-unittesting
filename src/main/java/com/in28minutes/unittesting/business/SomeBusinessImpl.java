package com.in28minutes.unittesting.business;

import com.in28minutes.unittesting.service.IDataService;

import java.util.Arrays;

public class SomeBusinessImpl {

    private IDataService iDataService;

    public void setIDataService(IDataService iDataService){
        this.iDataService = iDataService;
    }

    public int calculateSum(int[] args){
        int sum =0;
        for(int temp : args){
            sum += temp;
        }
        //Arrays.stream(args).reduce(Integer :: sum).orElse(0);
        return sum;
    }


    public int calculateSumUsingDataService(){
        int[] args =iDataService.retreiveData();
        int sum=0;
        for(int temp : args){
            sum += temp;
        }
        return sum;

    }
}
