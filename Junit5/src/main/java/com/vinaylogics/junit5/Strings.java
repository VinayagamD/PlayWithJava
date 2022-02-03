package com.vinaylogics.junit5;

public class Strings {

    public static boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }
}
