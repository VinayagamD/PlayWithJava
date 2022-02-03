package com.vinaylogics.junit5.parameterizedtest.arguments;

import com.vinaylogics.junit5.Strings;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArgumentSourceTest {
    @ParameterizedTest
    @ArgumentsSource(BlanksStringArgumentsProvider.class)
    void isBlank_ShouldReturnTrueForNullOrBlankStringsArgProvider(String input) {
        assertTrue(Strings.isBlank(input));
    }
}
