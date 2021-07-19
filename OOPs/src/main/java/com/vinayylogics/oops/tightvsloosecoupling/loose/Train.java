package com.vinayylogics.oops.tightvsloosecoupling.loose;

public class Train implements Transport{
    @Override
    public void start() {
        System.out.println("Train trip started...");
    }
}
