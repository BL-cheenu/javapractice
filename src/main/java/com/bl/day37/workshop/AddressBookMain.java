package com.bl.day37.workshop;


public class AddressBookMain {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Contacts contacts = addressBook.createContact();
        contacts.displayContact();
    }

}
