package com.vinaylogics.designpattern.creational.singleton;

public class DemoMultiThreadHelper2 {

    static class ThreadFoo implements Runnable {
        Singleton2 singleton;

        @Override
        public void run() {
           singleton  = Singleton2.getInstance("FOO");
           System.out.println(singleton.getValue());
        }
    }

    static class ThreadBar implements Runnable {
        Singleton2 singleton;
        @Override
        public void run() {
           singleton  = Singleton2.getInstance("BAR");
           System.out.println(singleton.getValue());
        }
    }


}
