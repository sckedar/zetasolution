package com.he.addressBook;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBook {

	private ArrayList<Contact> contactlist;

	public AddressBook() {
		contactlist = new ArrayList<>();
	}

	public void addContact(Contact contact) {
		if (findContact(contact.getName()) >= 0) {
			throw new IllegalArgumentException("Contact is already exists");
		}
		contactlist.add(contact);
	}

	public void deleteContact(String name) {

		int index = findContact(name);
		if (index == -1) {
			throw new IllegalArgumentException("No contact found");
		}
		this.contactlist.remove(index);
	}

	public void updateContact(String name, Contact contact) {
		int t = findContact(name);
		if (t == -1) {
			throw new IllegalArgumentException("No contact found");
		}
		int p = findContact(contact.getName());
		if (p > 0) {
			throw new IllegalArgumentException("duplicate entry");
		}
		this.contactlist.set(t, contact);
	}

	public List<Contact> searchByName(String name) {
		if (name.isEmpty()) {
			return this.contactlist;
		}
		return contactlist.stream().filter(e -> e.getName().toLowerCase().contains(name.toLowerCase()))
				.collect(Collectors.toList());
	}

	public List<Contact> searchByOrganisation(String organisation) {
		if (organisation.isEmpty()) {
			return this.contactlist;
		}
		return contactlist.stream().filter(e -> e.getOrganisation().toLowerCase().contains(organisation.toLowerCase()))
				.collect(Collectors.toList());
	}

	private int findContact(String contactName) {

		for (int i = 0; i < contactlist.size(); i++) {
			if (contactlist.get(i).getName().equalsIgnoreCase(contactName)) {
				return i;
			}
		}
		return -1;
	}

}