package com.bl.advance.java.day22.collection;

public class AddressBookSystem {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book...");

        Contacts contact = new Contacts(
                "demo",
                "Doe",
                "Street 123",
                "Chennai",
                "TamilNadu",
                "411001",
                "9876543210",
                "demo@gmail.com"
        );

        System.out.println("Contact Created Successfully:");
        contact.showContact();
    }
}
