package com.he.addressBook;

public class PhoneNumber {
	private String label;
	private String phoneNumber;

	public PhoneNumber(String label, String phoneNumber) throws Exception {

		if (label == null || label.isEmpty() || label.length() > 255
				|| !(label.chars().allMatch(Character::isLetter))) {
			throw new IllegalArgumentException("Invalid label");
		}
		if (phoneNumber == null || phoneNumber.length() != 10 || !phoneNumber.chars().allMatch(Character::isDigit)) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}

		this.label = label;
		this.phoneNumber = phoneNumber;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}