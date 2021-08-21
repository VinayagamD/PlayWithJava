package com.vinaylogics.designpattern.creational.singleton;

public class DemoMultiThreadHelper {

    static class ThreadFoo implements Runnable {
        Singleton1 singleton;

        @Override
        public void run() {
           singleton  = Singleton1.getInstance("FOO");
           System.out.println(singleton.getValue());
        }
    }

    static class ThreadBar implements Runnable {
        Singleton1 singleton;
        @Override
        public void run() {
           singleton  = Singleton1.getInstance("BAR");
           System.out.println(singleton.getValue());
        }
    }


}
