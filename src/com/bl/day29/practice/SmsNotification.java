package com.bl.day29.practice;

public class SmsNotification implements Notification{
    @Override
    public void send(String message) {
        System.out.println("Message send through SMS!!!");
    }
}
