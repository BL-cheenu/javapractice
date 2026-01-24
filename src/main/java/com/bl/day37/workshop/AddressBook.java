package com.bl.day37.workshop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

    List<Person> addresses = new ArrayList<>();

    // UC1 & UC5
    public void addPerson(Person person) {
        boolean isDuplicate = addresses.stream().anyMatch(existingPerson -> existingPerson.equals(person));
        if (isDuplicate) {
            System.out.println("This person already exists");
            return;
        }
        addresses.add(person);
        System.out.println("Person added successfully!");
    }

    public void displayAddresses() {
        if (addresses.isEmpty()) {
            System.out.println("Nothing to Display!");
            return;
        }

        System.out.println("----- Address Book -----");
        for (Person person : addresses) {
            System.out.println(person);
            System.out.println("----------------------");
        }
    }

    public void editPerson(String firstName) {
        Scanner sc = new Scanner(System.in);
        boolean found = false;

        for (Person person : addresses) {
            if (person.getFirstName().equals(firstName)) {
                found = true;

                System.out.print("Enter New Address: ");
                person.setAddress(sc.nextLine());

                System.out.print("Enter New City: ");
                person.setCity(sc.nextLine());

                System.out.print("Enter New State: ");
                person.setState(sc.nextLine());

                System.out.print("Enter New Zip: ");
                person.setZip(sc.nextLine());

                System.out.print("Enter New Email: ");
                person.setEmail(sc.nextLine());

                System.out.print("Enter New Phone Number: ");
                person.setPhoneNumber(sc.nextLine());

                System.out.println("Person details updated successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("Person not found!");
        }
    }

    public void deletePerson(String deleteFirstName) {
        boolean found = false;
        for (Person person : addresses) {
            if (person.getFirstName().equals(deleteFirstName)) {
                found = true;
                addresses.remove(person);
                System.out.println("Person deleted successfully!");
                break;
            }
        }
        if (!found) {
            System.out.println("Person not found!");
        }
    }

    public void sortByName() {

        List<Person> sortedList = addresses.stream()
                .sorted(Comparator.comparing(Person::getFirstName, String.CASE_INSENSITIVE_ORDER))
                .toList();

        if (sortedList.isEmpty()) {
            System.out.println("Nothing to Display!");
            return;
        }
        System.out.println("----- Address Book (Sorted by Name) -----");
        sortedList.forEach(System.out::println);
        System.out.println("---------------------");
    }

    public void sortByCity() {
        List<Person> personListSortedByCity = addresses.stream()
                .sorted(Comparator.comparing(Person::getCity, String.CASE_INSENSITIVE_ORDER))
                .toList();
        personListSortedByCity.forEach(System.out::println);
    }

    public void sortByState() {
        addresses.stream()
                .sorted(Comparator.comparing(Person::getState, String.CASE_INSENSITIVE_ORDER))
                .toList().forEach(System.out::println);
    }
}
