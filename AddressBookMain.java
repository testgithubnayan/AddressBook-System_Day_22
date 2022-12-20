package com.brigelabz;

import java.util.Scanner;

public class AddressBookMain {
	public static void main(String[] args) {

		System.out.println("********Welcome to  Advanced Address-book Programme **************");
		AddressBook addressBook = new AddressBook();
		Scanner scanner = new Scanner(System.in);
		addressBook.addNewAddressBook();
		addressBook.welcomeMassage();
		boolean flag = true;
		while (flag) {
			System.out.println(AddressBook.AllAddresssBookLIst.keySet());

			System.out.println(
					"Select option\n1.Add Contact\n2.Edit Contact\n3.view Contacts\n4.Delete Contact\n5.Add New AddressBook\n6.Select AddressBook\n7.Search Contact\n8.Sort Contact\n9.Exit");
			int option = scanner.nextInt();
			switch (option) {
			case 1:
				ContactPerson contact = addressBook.createContact();
				addressBook.addContact(contact);
				break;
			case 2:
				addressBook.editContact();
				break;
			case 3:
				addressBook.displayContact(addressBook.UsedAddressBook);
				break;
			case 4:
				addressBook.deleteContact();
				break;
			case 5:
				addressBook.addNewAddressBook();
				break;
			case 6:
				addressBook.selectAddressBook();
				break;
			case 7:
				addressBook.searchContact();
				break;
			case 8:
				addressBook.sortContact();
				break;

			case 9:
				addressBook.addMultipleContacts();
				break;
			case 10:
				addressBook.searchContact();
				break;
			default:
				System.out.println(option + " Thats Not A Valid Option!!!");
				break;

			}
		}
	}
}
