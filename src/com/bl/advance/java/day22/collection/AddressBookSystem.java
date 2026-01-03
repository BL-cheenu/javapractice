package com.bl.advance.java.day22.collection;

import java.util.ArrayList;
import java.util.List;

public class AddressBookSystem {
    List<Contacts> contactsArrayList = new ArrayList<>();

    public void addContact(Contacts contacts) {
        contactsArrayList.add(contacts);
        System.out.println("Contact Added Successfully!");
    }

    public void showALlContacts() {
        for (Contacts contacts : contactsArrayList) {
            contacts.showContact();
        }
    }
}
