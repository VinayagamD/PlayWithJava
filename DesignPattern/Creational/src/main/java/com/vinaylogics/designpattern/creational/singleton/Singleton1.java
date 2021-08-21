package com.vinaylogics.designpattern.creational.singleton;

public class Singleton1 {

    private static Singleton1 instance;

    private String value;

    private Singleton1(String value) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.value = value;
    }

    public static  Singleton1 getInstance(String value){
        if(instance == null){
            instance = new Singleton1(value);
        }

        return instance;
    }

    public String getValue() {
        return value;
    }
}
