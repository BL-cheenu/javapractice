package oopsandds.day10.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookSystem {
    List<Contacts> contacts = new ArrayList<>();

    public void addContact(Scanner scanner) {
        System.out.println("Welcome to Address Book Program");
        Contacts contact = new Contacts();

        System.out.print("Enter First Name: ");
        contact.setFirstName(scanner.nextLine());

        System.out.print("Enter Last Name: ");
        contact.setLastName(scanner.nextLine());

        System.out.print("Enter Address: ");
        contact.setAddress(scanner.nextLine());

        System.out.print("Enter City: ");
        contact.setCity(scanner.nextLine());

        System.out.print("Enter State: ");
        contact.setState(scanner.nextLine());

        System.out.print("Enter Zip: ");
        contact.setZip(scanner.nextLine());

        System.out.print("Enter Phone Number: ");
        contact.setPhoneNumber(scanner.nextLine());

        System.out.print("Enter Email: ");
        contact.setEmail(scanner.nextLine());

        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }

    public void displayAllContacts() {
        System.out.println("--- Contact List ---");
        for (Contacts contact : contacts) {
            contact.displayContact();
        }
    }

    public void editContact(String name, Scanner scanner) {
        for (Contacts contacts1 : contacts) {
            if (contacts1.getFirstName().equalsIgnoreCase(name)) {
                System.out.println("Contact found. Enter new details:");

                System.out.print("Enter New Address: ");
                contacts1.setAddress(scanner.nextLine());

                System.out.print("Enter New City: ");
                contacts1.setCity(scanner.nextLine());

                System.out.print("Enter New State: ");
                contacts1.setState(scanner.nextLine());

                System.out.print("Enter New Zip: ");
                contacts1.setZip(scanner.nextLine());

                System.out.print("Enter New Phone Number: ");
                contacts1.setPhoneNumber(scanner.nextLine());

                System.out.print("Enter New Email: ");
                contacts1.setEmail(scanner.nextLine());

                System.out.println("Contact updated successfully!");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void deleteContact(String name) {
        for (Contacts contact : contacts) {

            if (contact.getFirstName().equalsIgnoreCase(name)) {
                contacts.remove(contact);
                System.out.println("Contact deleted successfully!");
                return;
            }
        }

        System.out.println("Contact not found.");
    }
}
