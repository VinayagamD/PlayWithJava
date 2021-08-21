package com.vinayylogics.oops.tightvsloosecoupling.testbasics;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TestNull {

    public static void main(String[] args) {
        Object object = new Object();
        System.out.println(object.hashCode());
        object = null;
//        System.out.println(object.hashCode());
        System.out.println(Objects.hashCode(null));
        Map<String,String> map = new HashMap<>();
    }
}
