package com.vinaylogics.junit5.parameterizedtest;

import com.vinaylogics.junit5.Numbers;
import com.vinaylogics.junit5.Strings;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValueSourceTest {

    @ParameterizedTest(name = "{index} : {0}")
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
    void testIsOdd_ShouldReturnTrueForOddNumbers(int number) {
        assertTrue(Numbers.isOdd(number));
    }

    @ParameterizedTest(name = "{index} : {0}")
    @ValueSource(strings = {"", "  "})
    void testIsBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
        assertTrue(Strings.isBlank(input));
    }

    @ParameterizedTest(name = "{index} : {0}")
    @NullSource
    void testIsBlank_ShouldReturnTrueForNullInputs(String input) {
        assertTrue(Strings.isBlank(input));
    }

    @ParameterizedTest(name = "{index} : {0}")
    @EmptySource
    void testIsBlank_ShouldReturnTrueForEmptyStrings(String input) {
        assertTrue(Strings.isBlank(input));
    }

    @ParameterizedTest(name = "{index} : {0}")
    @NullAndEmptySource
    void testIsBlank_ShouldReturnTrueForNullAndEmptyStrings(String input) {
        assertTrue(Strings.isBlank(input));
    }

    @ParameterizedTest(name = "{index} : {0}")
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    void testIsBlank_ShouldReturnTrueForAllTypesOfBlankStrings(String input) {
        assertTrue(Strings.isBlank(input));
    }
}