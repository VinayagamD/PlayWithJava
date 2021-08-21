package com.vinaylogics.designpattern.creational.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingletonTest {


    @Test
    @DisplayName("Test Non Thread Safe Singleton Instance")
    public void testSingleton1Instance(){
        Singleton1 singleton = Singleton1.getInstance("FOO");
        Singleton1 anotherSingleton = Singleton1.getInstance("BAR");
        assertEquals("FOO", singleton.getValue());
        assertEquals("FOO", anotherSingleton.getValue());
    }

    @Test
    @DisplayName("Test Non Thread Safe Singleton Instance For MultiThread")
    public void testSingleton1Instance_MultiThread() throws InterruptedException {
        DemoMultiThreadHelper.ThreadFoo foo = new DemoMultiThreadHelper.ThreadFoo();
        DemoMultiThreadHelper.ThreadBar bar = new DemoMultiThreadHelper.ThreadBar();
        Thread threadFoo = new Thread(foo);
        Thread threadBar = new Thread(bar);
        threadFoo.start();
        threadBar.start();
        threadFoo.join();
        threadBar.join();
        assertEquals("FOO", foo.singleton.getValue());
        assertEquals("BAR", bar.singleton.getValue());
    }

    @Test
    @DisplayName("Test Thread Safe Singleton Instance For MultiThread")
    public void testSingleton1Instance_MultiThreadThreadSafe() throws InterruptedException {
        DemoMultiThreadHelper2.ThreadFoo foo = new DemoMultiThreadHelper2.ThreadFoo();
        DemoMultiThreadHelper2.ThreadBar bar = new DemoMultiThreadHelper2.ThreadBar();
        Thread threadFoo = new Thread(foo);
        Thread threadBar = new Thread(bar);
        threadFoo.start();
        threadBar.start();
        threadFoo.join();
        threadBar.join();
        assertEquals("FOO", foo.singleton.getValue());
        assertEquals("FOO", bar.singleton.getValue());
    }
}