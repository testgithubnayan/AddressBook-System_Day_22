package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {
	Scanner sc = new Scanner(System.in);
	static HashMap<String, ArrayList<ContactPerson>> AllAddresssBookLIst = new HashMap<>();
	static ArrayList<ContactPerson> UsedAddressBook;
	static String UsedAddressBookName;

	void welcomeMassage() {

		int i, j, row = 6;

		for (i = 0; i < row; i++) {
			// inner loop work for space
			for (j = row - i; j > 1; j--) {

				System.out.print(" ");
			}
			// inner loop for columns
			for (j = 0; j <= i; j++) {

				System.out.print("  * ");

			}
			System.out.println();

		}
	}

//	This operation enables consumers to add, change, or delete address book records.
	// The operation also enables users to add, change, or delete the
//	Who's Who records in the Address Book.
	public ContactPerson createContact() {
		ContactPerson person = new ContactPerson();
		System.out.print("Enter First Name: ");
		person.setFirstName(sc.next());
		System.out.print("Enter Last Name: ");
		person.setLastName(sc.next());
		System.out.print("Enter Address: ");
		person.setAddress(sc.next());
		System.out.print("Enter City: ");
		person.setCity(sc.next());
		System.out.print("Enter State: ");
		person.setState(sc.next());
		System.out.print("Enter email: ");
		person.setEmail(sc.next());
		System.out.print("Enter ZipCode: ");
		person.setZipCode(sc.nextInt());
		System.out.print("Enter Phone Number: ");
		person.setPhoneNumber(sc.nextLong());
		System.out.println("created new contact");
		return person;
	}

	public void addContact() {
		ContactPerson contactPerson = createContact();
		UsedAddressBook.add(contactPerson);
		System.out.println(contactPerson);
		System.out.println("Contact added successfully");
	}

	public void editContact() {
		boolean ContactFound = false;
		System.out.println("Enter Name to edit Contact");
		String name = sc.next();
		for (ContactPerson contactPerson : UsedAddressBook) {
			if (name.equals(contactPerson.getFirstName())) {
				ContactFound = true;
				System.out.print("Enter First Name :");
				contactPerson.setFirstName(sc.next());
				System.out.print("Enter Last Name :");
				contactPerson.setLastName(sc.next());
				System.out.print("Enter Address :");
				contactPerson.setAddress(sc.next());
				System.out.print("Enter City :");
				contactPerson.setCity(sc.next());
				System.out.print("Enter State :");
				contactPerson.setState(sc.next());
				System.out.print("Enter email :");
				contactPerson.setEmail(sc.next());
				System.out.print("Enter ZipCode :");
				contactPerson.setZipCode(sc.nextInt());
				System.out.print("Enter Phone Number :");
				contactPerson.setPhoneNumber(sc.nextLong());
				System.out.println(contactPerson);
				break;
			}
		}
		if (ContactFound) {
			System.out.println("CONTACT  SUCCESSFULLY ADDED..");
		} else {
			System.out.println("OOPS...CONTACT NOT FOUND");
		}
	}

	public void deleteContact() {

		System.out.println("ENTER NAME TO DELETE CONTACT:");
		String name = sc.next();
		for (ContactPerson contactPerson : UsedAddressBook) {
			if (contactPerson.getFirstName().equals(name)) {
				System.out.println("CONTACT FOUND:");
				System.out.println(contactPerson);
				System.out.println("CONFIRM TO DELETE Y AND N FOR NO");
				if (sc.next().equals("y")) {
					UsedAddressBook.remove(contactPerson);
					System.out.println("CONTACT DELETED");
				}
				break;
			}
		}

	}

	public void addMultipleContacts() {
		System.out.println(" YES ENTER  THE MULTIPLE CONTACTS: ");
		ContactPerson contactPerson = createContact();
		UsedAddressBook.add(contactPerson);
		System.out.println(contactPerson);
		System.out.println("Contact added successfully");
	}

	void addNewAddressBook() {
		System.out.println("Enter name for AddressBook: ");
		String addressBookName = sc.next();
		ArrayList<ContactPerson> addressBook = new ArrayList<ContactPerson>();
		AllAddresssBookLIst.put(addressBookName, addressBook);
		System.out.println("new AddressBook created");
		UsedAddressBook = AllAddresssBookLIst.get(addressBookName);
		UsedAddressBookName = addressBookName;
	}

	void selectAddressBook() {
		System.out.println(AllAddresssBookLIst.keySet());
		System.out.println("Enter name of address book:");
		String addressBookNaming = sc.next();

		for (String key : AllAddresssBookLIst.keySet()) {
			if (key.equals(addressBookNaming)) {
				UsedAddressBook = AllAddresssBookLIst.get(key);
				UsedAddressBookName = key;
			}
		}
		System.out.println(" AddressBook is: " + UsedAddressBookName);
	}

	void displayContact(ArrayList<?> addressBook) {
		System.out.println("Contacts: ");
		for (Object O : addressBook) {
			ContactPerson person = (ContactPerson) O;
			System.out.println(person);
		}

	}

	boolean checkDuplicateContact(ContactPerson newPerson) {
		return UsedAddressBook.stream().anyMatch((person) -> person.getFirstName().equals(newPerson.getFirstName()));
	}
}
