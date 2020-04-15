package com.in28minutes.unittesting;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        int []arr=    new int[]{2,5,1,34,10,4};
        List res = getSmallestAndLargestElement(arr);
        System.out.println(res.get(0));
        System.out.println(res.get(1));
    }
    public static List<Integer> getSmallestAndLargestElement(int[] arr){

        int smallElement = java.lang.Integer.MAX_VALUE;
        int largestElement = java.lang.Integer.MIN_VALUE;

        for(int i=0,j=arr.length-1;i<=j;i++,j--){
            if(arr[i] > largestElement)
                largestElement = arr[i];
            if(arr[i] < smallElement)
                smallElement = arr[j];

            if(arr[j] > largestElement)
                largestElement = arr[i];
            if(arr[j] < smallElement)
                smallElement = arr[j];
        }
        List<Integer> result = new ArrayList<java.lang.Integer>();
        result.add(smallElement);
        result.add(largestElement);

        return result;
    }


}
