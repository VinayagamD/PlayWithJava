package com.vinaylogics.designpattern.creational.singleton;

public class Singleton2 {

    private volatile static Singleton2 instance;

    private String value;

    private Singleton2(String value) {
        this.value = value;
    }

    public static Singleton2 getInstance(String value){
        Singleton2 result = instance;
        if(result != null){
            return result;
        }
        synchronized (Singleton2.class) {
            if (instance == null) {
                instance = new Singleton2(value);
            }

            return instance;
        }
    }

    public String getValue() {
        return value;
    }
}
