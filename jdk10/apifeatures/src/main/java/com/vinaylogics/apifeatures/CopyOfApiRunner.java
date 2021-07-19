package com.vinaylogics.apifeatures;

import java.util.ArrayList;
import java.util.List;

public class CopyOfApiRunner {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Ranga");
        names.add("Ravi");
        names.add("John");
//        doNotChange(names);
        List<String> copyOfNames = List.copyOf(names);
        doNotChange(copyOfNames);
        System.out.println(copyOfNames);
    }

    private static void doNotChange(List<String> names) {
        names.add("ShouldNotBeAllowed");
    }
}
