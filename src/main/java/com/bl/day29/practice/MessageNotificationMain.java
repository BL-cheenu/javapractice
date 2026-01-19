package com.bl.day29.practice;

public class MessageNotificationMain {
    public static void main(String[] args) {
        NotificationServiceImpl service = new NotificationServiceImpl();
        service.send("Email", "Hi");
        service.send("SMS", "Hello");
    }
}
