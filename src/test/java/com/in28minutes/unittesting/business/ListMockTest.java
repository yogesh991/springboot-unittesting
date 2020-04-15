package com.in28minutes.unittesting.business;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    private List<String> mockList = mock(List.class);

    @Test
    public void sizeTest(){

        when(mockList.size()).thenReturn(5);
        assertEquals(mockList.size(),5);
    }

    @Test
    public void differentValuesTest(){
        when(mockList.size()).thenReturn(5).thenReturn(10);
        assertEquals(mockList.size(),5);
        assertEquals(mockList.size(),10);
    }

    @Test
    public void stringTest(){
        when(mockList.get(anyInt())).thenReturn("test");
        assertEquals(mockList.get(0),"test"); //pass test case
        assertEquals(mockList.get(1),"test"); //pass test case

    }

    @Test
    public void verificationBasics(){
        String val1 = mockList.get(0);
        String val2 = mockList.get(1);

        verify(mockList).get(0);
        verify(mockList,times(2)).get(anyInt());
        verify(mockList,atLeast(1)).get(anyInt());
        verify(mockList,atLeastOnce()).get(anyInt());
        verify(mockList,atMost(2)).get(anyInt());
        //verify(mockList,atMostOnce()).get(anyInt());
        verify(mockList,never()).get(2);

    }


    @Test
    public void argumentCapturing(){
        mockList.add("something");
        mockList.add("something1");
        mockList.add("something2");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockList,times(3)).add(captor.capture());

        List<String> values = captor.getAllValues();
        assertEquals("something",values.get(0));
        assertEquals("something1",values.get(1));
        assertEquals("something2",values.get(2));

    }

    @Test
    public void mocking(){
        //All method of list class gives default values, unless we override them.

        ArrayList list = mock(ArrayList.class);
        System.out.println(list.get(0)); //null
        System.out.println(list.size()); //0
        System.out.println(list.add("test")); //false
        list.add("test1");
        System.out.println(list.size()); //0
        when(list.size()).thenReturn(5);
        System.out.println(list.size()); //5
    }


    @Test
    public void spying(){
        //All method of list class behaves like an original class.

        ArrayList spyList = spy(ArrayList.class);
        spyList.add("first");
        System.out.println(spyList.get(0)); //throw Exception
        System.out.println(spyList.size()); //1
        System.out.println(spyList.add("test")); //true
        spyList.add("test1");
        System.out.println(spyList.size()); //3
        when(spyList.size()).thenReturn(5);
        System.out.println(spyList.size()); //5
        spyList.add("test100");
        System.out.println(spyList.size());//5

        verify(spyList).add("something");


    }
}
