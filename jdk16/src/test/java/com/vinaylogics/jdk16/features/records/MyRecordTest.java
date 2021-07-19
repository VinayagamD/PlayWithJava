package com.vinaylogics.jdk16.features.records;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyRecordTest {

    @Test
    @DisplayName("Should create bew record")
    void shouldCreateNewRecord(){
        MyRecord vinay = new MyRecord("Vinay", 23456);
        System.out.println(vinay);
        assertEquals("Vinay", vinay.name());
    }

}