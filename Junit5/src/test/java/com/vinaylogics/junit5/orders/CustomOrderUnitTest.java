package com.vinaylogics.junit5.orders;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(CustomOrder.class)
public class CustomOrderUnitTest {
    private static StringBuilder output = new StringBuilder("");

    @Test
    public void myATest() {
        output.append("A");
    }

    @Test
    public void myBTest() {
        output.append("B");
    }

    @Test
    public void myaTest() {
        output.append("a");
    }


    @AfterAll
    public static void assertOutput() {
        assertEquals(output.toString(), "AaB");
    }
}
