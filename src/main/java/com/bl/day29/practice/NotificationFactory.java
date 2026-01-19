package com.bl.day29.practice;

public class NotificationFactory {
    public static Notification getNotification(String type) {
        if (type.equalsIgnoreCase("Email")){
            return new EmailNotification();
        }else if (type.equalsIgnoreCase("SMS")){
            return new SmsNotification();
        }
        throw new RuntimeException("Invalid notification type");
    }
}
