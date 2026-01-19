package com.bl.day29.practice;

public class EmailNotification implements Notification{
    @Override
    public void send(String message) {
        System.out.println("Message send through Email!!!");
    }
}
