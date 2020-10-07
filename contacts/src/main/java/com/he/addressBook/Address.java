package com.he.addressBook;

public class Address {

	private String label;
	private String address;

	public Address(String label, String address) throws Exception {
		if (label == null || label.isEmpty() || label.length() > 255
				|| !(label.chars().allMatch(Character::isLetter))) {
			throw new IllegalArgumentException("Invalid label");
		}
		this.label = label;
		this.address = address;
	}

	public String getLabel() {
		return this.label;
	}

	public String getAddress() {
		return this.address;
	}
}