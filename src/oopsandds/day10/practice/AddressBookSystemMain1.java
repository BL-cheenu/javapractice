package oopsandds.day10.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookSystemMain1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, AddressBookSystem> addressBookSystemMap = new HashMap<>();
        while (true) {
            System.out.println("Welcome to Address Book Program");
            System.out.println("-----------------------------");
            System.out.println("1. Create Address Book");
            System.out.println("2. Add Contact to Address Book");
            System.out.println("3. Display Address Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            System.out.println("-----------------------------");
            System.out.print("Enter your Choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter Address Book Name: ");
                    String name = scanner.nextLine();

                    addressBookSystemMap.put(name, new AddressBookSystem());
                    break;
                case 2:
                    System.out.print("Enter Address Book Name: ");
                    String addedName = scanner.nextLine();

                    AddressBookSystem bookSystem = addressBookSystemMap.get(addedName);
                    if (bookSystem != null) {
                        bookSystem.addContact(scanner);
                    } else {
                        System.out.println("Address Book not found");
                    }
                    break;
                case 3:
                    System.out.print("Enter Address Book Name: ");
                    String savedBook = scanner.nextLine();

                    AddressBookSystem book = addressBookSystemMap.get(savedBook);
                    if (book != null) {
                        book.displayAllContacts();
                    } else {
                        System.out.println("Address Book not found");
                    }
                case 4:
                    System.out.println("Exiting Address Book");
                    return;

            }
        }

    }
}
