package com.bl.advance.java.day22.collection;

import java.util.Scanner;

public class AddressBookSystemMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddressBookSystem book = new AddressBookSystem();

        System.out.print("Enter First Name : ");
        String firstName = sc.nextLine();

        System.out.print("Enter Last Name : ");
        String lastName = sc.nextLine();

        System.out.print("Enter Address : ");
        String address = sc.nextLine();

        System.out.print("Enter City : ");
        String city = sc.nextLine();

        System.out.print("Enter State : ");
        String state = sc.nextLine();

        System.out.print("Enter Zip : ");
        String zip = sc.nextLine();

        System.out.print("Enter Phone Number : ");
        String phone = sc.nextLine();

        System.out.print("Enter Email : ");
        String email = sc.nextLine();

        Contacts contact = new Contacts(firstName, lastName, address, city, state, zip, phone, email);
        book.addContact(contact);

        book.showALlContacts();
    }
}
