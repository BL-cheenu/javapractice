package com.bl.advance.java.day22.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookSystem {
    List<Contacts> contactsArrayList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addContact(Contacts contacts) {
        contactsArrayList.add(contacts);
        System.out.println("Contact Added Successfully!");
    }

    public void showALlContacts() {
        for (Contacts contacts : contactsArrayList) {
            contacts.showContact();
        }
    }

    public void editContact() {
        System.out.print("Enter First name of contact to edit: ");
        String name = sc.nextLine();

        for (Contacts contact : contactsArrayList) {
            if (contact.firstName.equalsIgnoreCase(name)) {
                System.out.println("Contact Found! Enter new details:");

                System.out.print("Enter Last Name : ");
                contact.lastName = sc.nextLine();

                System.out.print("Enter Address : ");
                contact.address = sc.nextLine();

                System.out.print("Enter City : ");
                contact.city = sc.nextLine();

                System.out.print("Enter State : ");
                contact.state = sc.nextLine();

                System.out.print("Enter Zip : ");
                contact.zip = sc.nextLine();

                System.out.print("Enter Phone Number : ");
                contact.phoneNumber = sc.nextLine();

                System.out.print("Enter Email : ");
                contact.email = sc.nextLine();

                System.out.print("Contact Updated Successfully!");
                return;
            }
        }
        System.out.println("Contact Not Found!");
    }
}
