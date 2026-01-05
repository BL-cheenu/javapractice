package com.bl.advance.java.day22.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBookSystem {
    List<Contacts> contactList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addContact(Contacts contacts) {
        if (contactList.isEmpty()) {
            contactList.add(contacts);
            System.out.println("Contact Added Successfully!");
        } else {
            boolean isDuplicate = contactList.stream()
                    .anyMatch(contacts1 -> contacts1.firstName.equalsIgnoreCase(contacts.firstName));
            if (isDuplicate) {
                System.out.println("Duplicate Entry! Person already exists.");
            } else {
                contactList.add(contacts);
                System.out.println("Contact Added Successfully!");
            }
        }
    }

    public void showALlContacts() {
        if (contactList.isEmpty()) {
            System.out.println("Address Book is Empty!");
            return;
        }

        for (Contacts c : contactList) {
            c.showContact();
        }
    }

    public void editContact() {
        System.out.print("Enter First name of contact to edit: ");
        String name = sc.nextLine();

        for (Contacts contact : contactList) {
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

    public void deleteContact() {
        System.out.print("Enter First name of contact to delete: ");
        String name = sc.nextLine();

        for (Contacts contact : contactList) {
            if (contact.firstName.equalsIgnoreCase(name)) {
                contactList.remove(contact);
                System.out.println("Contact deleted Successfully");
                return;
            }
        }
        System.out.println("Contact Not Found!");
    }

    public void searchPersonByCity(String city, Map<String, AddressBookSystem> addressBookSystemMap) {
        System.out.println("People in city : " + city);
        if (city.isEmpty()) {
            System.out.println("City must have a value");
            return;
        }
        addressBookSystemMap.values().stream()
                .flatMap(book -> book.contactList.stream())
                .filter(contacts -> contacts.city.equalsIgnoreCase(city))
                .forEach(contacts -> System.out.println(contacts.firstName + " " + contacts.lastName));
    }

    public void searchPersonByState(String state, Map<String, AddressBookSystem> addressBookSystemMap) {
        System.out.println("People in city : " + state);
        if (state.isEmpty()) {
            System.out.println("City must have a value");
            return;
        }
        addressBookSystemMap.values().stream()
                .flatMap(book -> book.contactList.stream())
                .filter(contacts -> contacts.state.equalsIgnoreCase(state))
                .forEach(contacts -> System.out.println(contacts.firstName + " " + contacts.lastName));
    }

    public void viewPersonByCity(String city, Map<String, AddressBookSystem> addressBookSystemMap) {
        System.out.println("People in City : " + city);

        addressBookSystemMap.values().stream()
                .flatMap(book -> book.contactList.stream())
                .filter(c -> c.city.equalsIgnoreCase(city))
                .forEach(c -> System.out.println(c.firstName + " " + c.lastName));
    }

    public void viewPersonByState(String state, Map<String, AddressBookSystem> addressBookSystemMap) {
        System.out.println("People in State : " + state);

        addressBookSystemMap.values().stream()
                .flatMap(book -> book.contactList.stream())
                .filter(c -> c.state.equalsIgnoreCase(state))
                .forEach(c -> System.out.println(c.firstName + " " + c.lastName));
    }
}
