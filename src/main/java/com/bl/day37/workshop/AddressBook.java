package com.bl.day37.workshop;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    List<Person> addresses = new ArrayList<>();

    public void addPerson(Person person) {
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
}
