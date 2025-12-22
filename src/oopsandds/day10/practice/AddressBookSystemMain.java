package oopsandds.day10.practice;


import java.util.Scanner;

public class AddressBookSystemMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        while (true) {
            System.out.println("Welcome to Address Book Program");
            System.out.println("-----------------------------");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Display Contacts");
            System.out.println("4: Delete Contacts");
            System.out.println("5. Exit");
            System.out.println("-----------------------------");
            System.out.print("Enter your Choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    while (true) {
                        addressBookSystem.addContact(scanner);
                        System.out.print("Do you want to add another contact? (Y/N): ");
                        String option = scanner.nextLine();
                        if (!option.equalsIgnoreCase("Y")) {
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter First Name to Edit: ");
                    addressBookSystem.editContact(scanner.nextLine(), scanner);
                    break;
                case 3:
                    addressBookSystem.displayAllContacts();
                    break;
                case 4:
                    System.out.print("Enter First Name to Delete: ");
                    addressBookSystem.deleteContact(scanner.nextLine());
                    break;
                case 5:
                    System.out.println("Exiting Address Book");
                    return;
                default:
                    System.out.println("Invalid input, Please choose valid one.");
            }
        }
    }
}
