package com.in28minutes.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonTesting {

    private String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test
    public void jsonTesting_basic() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse,actualResponse,true);
    }

    @Test
    public void jsonTesting() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10}";
        JSONAssert.assertEquals(expectedResponse,actualResponse,false);
    }

    @Test
    public void jsonTesting_2Test() throws JSONException {
        String expectedResponse = "{id:1,name:Ball,price:10,quantity:100,quantity:100}";
        JSONAssert.assertEquals(expectedResponse,actualResponse,true);
    }
}
