package com.vinaylogics.apifeatures;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OfApiRunner {

    public static void main(String[] args) {
        System.out.println(List.of(1,2,3,4,5,6,7,8));
        System.out.println(Set.of(1,2,3,4,5,6,7,8));
        System.out.println(Map.of("a",10, "b", 20, "c", 30));
    }
}
