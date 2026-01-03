package com.bl.advance.java.day22.collection;

import java.util.Scanner;

public class AddressBookSystemMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddressBookSystem book = new AddressBookSystem();

        while (true) {
            System.out.println("--- Address Book Menu ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Show Contacts");
            System.out.println("4. Exit");

            System.out.print("Enter choice : ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
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

                    break;
                case 2:
                    book.editContact();
                    break;

                case 3:
                    book.showALlContacts();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }


    }
}
