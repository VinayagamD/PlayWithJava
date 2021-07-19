package com.vinaylogics.jdk9.module_exaple.welcome;

import com.vinaylogics.jdk9.module_example.hello_module.HelloWorld;
import com.vinaylogics.jdk9.module_example.youtube_module.HelloYoutube;

public class Main {

    public static void main(String[] args) {
        HelloYoutube helloYoutube = new HelloYoutube();
        helloYoutube.print();
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.print();
    }
}
