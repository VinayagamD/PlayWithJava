package com.vinaylogics.playwithjava.solid.basics.srp;

public class NotificationService {


    public void sendOTP(String medium) {
        switch (medium) {
            case "email" -> {
                // write email related logic
                // use Java Mail SenderAPI
            }
            case "mobile" -> {
                // write logic using twillio API
            }
        }
    }
}