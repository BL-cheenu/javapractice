package com.bl.day29.practice;

public class NotificationServiceImpl {
    public void send(String type, String message){
        Notification notification = NotificationFactory.getNotification(type);
        notification.send(message);

    }
}
