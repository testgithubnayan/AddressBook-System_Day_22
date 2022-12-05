package com.bridgelabz;

public class AddressBookMain {

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book program");
        AddressBook addressBook = new AddressBook();
        System.out.println(addressBook.createContact());
    }
}
