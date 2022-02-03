package com.vinaylogics.junit5.parameterizedtest.arguments.conversions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImplicitConversionTest {

    @ParameterizedTest
    @CsvSource({"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"}) // Passing strings
    void someMonths_Are30DaysLongCsv(Month month) {
        final boolean isALeapYear = false;
        assertEquals(30, month.length(isALeapYear));
    }

}
