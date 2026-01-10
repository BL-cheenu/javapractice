package com.bl.day27.io.problem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


public class AddressBook {
    List<Contacts> contactList = new ArrayList<>();

    private static final String FILE_PATH = "D:\\learning\\AddressBook.txt";
    private static final String CSV_FILE = "D:\\learning\\AddressBook.csv";
    private static final String JSON_FILE = "D:\\learning\\AddressBook.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();


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

    public void searchPersonByCity(String city, Map<String, AddressBook> addressBookSystemMap) {
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

    public void searchPersonByState(String state, Map<String, AddressBook> addressBookSystemMap) {
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

    public void viewPersonByCity(String city, Map<String, AddressBook> addressBookSystemMap) {
        System.out.println("People in City : " + city);

        addressBookSystemMap.values().stream()
                .flatMap(book -> book.contactList.stream())
                .filter(c -> c.city.equalsIgnoreCase(city))
                .forEach(c -> System.out.println(c.firstName + " " + c.lastName));
    }

    public void viewPersonByState(String state, Map<String, AddressBook> addressBookSystemMap) {
        System.out.println("People in State : " + state);

        addressBookSystemMap.values().stream()
                .flatMap(book -> book.contactList.stream())
                .filter(c -> c.state.equalsIgnoreCase(state))
                .forEach(c -> System.out.println(c.firstName + " " + c.lastName));
    }

    public void countPersonByCity(Map<String, AddressBook> addressBookSystemMap) {
        System.out.println("---- Count By City ----");
        List<Contacts> allContacts = addressBookSystemMap.values().stream()
                .flatMap(book -> book.contactList.stream())
                .collect(Collectors.toList());

        Map<String, Long> cityCount = allContacts.stream()
                .collect(Collectors.groupingBy(c -> c.city, Collectors.counting()));

        cityCount.forEach((city, count) -> System.out.println(city + " " + count));

    }

    public void countPersonByState(Map<String, AddressBook> addressBookSystemMap) {
        System.out.println("---- Count By State ----");
        List<Contacts> allContacts = addressBookSystemMap.values().stream()
                .flatMap(book -> book.contactList.stream())
                .collect(Collectors.toList());

        Map<String, Long> stateCount = allContacts.stream()
                .collect(Collectors.groupingBy(c -> c.city, Collectors.counting()));

        stateCount.forEach((state, count) -> System.out.println(state + " " + count));

    }

    public void sortedByPersonName() {
        if (contactList.isEmpty()) {
            System.out.println("Address Book is Empty!");
            return;
        }
        System.out.println("Contacts Sorted Alphabetically by Name:");
        contactList.stream()
                .sorted((c1, c2) -> c1.firstName.compareToIgnoreCase(c2.firstName))
                .forEach(System.out::println);
    }

    public void sortedByCity() {
        if (contactList.isEmpty()) {
            System.out.println("Address Book is Empty!");
            return;
        }

        contactList.stream()
                .sorted((c1, c2) -> c1.city.compareToIgnoreCase(c2.city))
                .forEach(System.out::println);
    }

    public void sortedByState() {
        if (contactList.isEmpty()) {
            System.out.println("Address Book is Empty!");
            return;
        }

        contactList.stream()
                .sorted((c1, c2) -> c1.state.compareToIgnoreCase(c2.state))
                .forEach(System.out::println);
    }

    public void sortedByZip() {
        if (contactList.isEmpty()) {
            System.out.println("Address Book is Empty!");
            return;
        }

        contactList.stream()
                .sorted((c1, c2) -> c1.zip.compareTo(c2.zip))
                .forEach(System.out::println);
    }

    public void writeContactsToFile(List<Contacts> contactList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Contacts c : contactList) {
                writer.write(
                        c.firstName + "," +
                                c.lastName + "," +
                                c.address + "," +
                                c.city + "," +
                                c.state + "," +
                                c.zip + "," +
                                c.phoneNumber + "," +
                                c.email
                );
                writer.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readContactsFromFile() {
        System.out.println("--- Reading Address Book File ---");

        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
             while ((line = reader.readLine()) != null){
                 String[] data = line.split(",");

                 System.out.println(
                         "Name : " + data[0] + " " + data[1] +
                                 ", City : " + data[3] +
                                 ", Phone : " + data[6]
                 );
             }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeContactsToCSV(List<Contacts> contactList) {

        File file = new File(CSV_FILE);

        try {
            file.getParentFile().mkdirs();

            boolean fileIsEmpty = !file.exists() || file.length() == 0;

            try (CSVWriter writer =
                         new CSVWriter(new FileWriter(file, true))) { // APPEND MODE

                if (fileIsEmpty) {
                    writer.writeNext(new String[]{
                            "FirstName","LastName","Address","City",
                            "State","Zip","Phone","Email"
                    });
                }

                for (Contacts c : contactList) {
                    writer.writeNext(new String[]{
                            c.firstName,
                            c.lastName,
                            c.address,
                            c.city,
                            c.state,
                            c.zip,
                            c.phoneNumber,
                            c.email
                    });
                }
            }

            System.out.println("Contacts appended to CSV successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static List<Contacts> readContactsFromCSV() {

        List<Contacts> contactList = new ArrayList<>();

        try (CSVReader reader = new CSVReaderBuilder(
                new InputStreamReader(
                        new FileInputStream(CSV_FILE),
                        StandardCharsets.UTF_8))
                .withSkipLines(1)
                .build()) {

            String[] line;

            while ((line = reader.readNext()) != null) {
                contactList.add(new Contacts(
                        line[0], line[1], line[2], line[3],
                        line[4], line[5], line[6], line[7]
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return contactList;
    }
    public static void writeToJson(List<Contacts> contactList) {

        if (contactList.isEmpty()) {
            System.out.println("No contacts to write into JSON.");
            return;
        }

        try (FileWriter writer = new FileWriter(JSON_FILE)) {
            gson.toJson(contactList, writer);
            System.out.println("Address Book written to JSON successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Contacts> readFromJson() {
        List<Contacts> contactList = new ArrayList<>();
        try (FileReader reader = new FileReader(JSON_FILE)) {

            Type listType = new TypeToken<List<Contacts>>() {}.getType();
            contactList = gson.fromJson(reader, listType);

            if (contactList == null) {
                contactList = new ArrayList<>();
            }
            System.out.println("Contacts loaded from JSON: " + contactList.size());
        } catch (Exception e) {
            System.out.println("JSON file not found or empty.");
        }
        return contactList;
    }

}
