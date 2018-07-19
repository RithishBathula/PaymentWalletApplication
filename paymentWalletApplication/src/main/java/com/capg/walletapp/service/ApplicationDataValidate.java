package com.capg.walletapp.service;

public class ApplicationDataValidate {

	public boolean validateAge(int age) {
		if (age > 18) {
			return true;
		}

		else {
			System.err.println("Age should be greater than 18");
			return false;
		}

	}

	public boolean validateMail(String email) {
		if(email.isEmpty()) {
			System.err.println("email cannot be empty");
		}
		else if (email.endsWith("@gmail.com")) {
			return true;
		} else
			System.err.println("mail should be in ******@gmail.com format");
		return false;
	}

	public boolean validateUsername(String username) {

		if (username.isEmpty()) {
			System.err.println("Username should not be empty");
			return false;
		}
		if (username.contains(" ")) {
			System.err.println("UserName should not contain any space");
			return false;
		} else
			return true;

	}

	public boolean validatePassword(String password) {
		
		if (password.isEmpty()) {

			System.err.println("Password cannot be empty");
			return false;
		}
		else {
			if (password.length() >= 8) {
				if (password.contains(" ")) {
					System.err.println("Password should not have any spaces");
					return false;
				}
				return true;
			}
			
		}
		return false;
	}

	public boolean validateContact(String contact) {
		if (contact.isEmpty()) {
			System.err.println("Contact must be entered");
			return false;
		}
		if (contact.length() == 10) {
			return true;
		}
		if (contact.contains(" ")) {
			System.err.println("enter valid contact without spaces");
		}
		if (contact.length() != 10) {
			System.err.println("Enter valid phoneNumber");
			return false;
		}
		return false;
	}

	public boolean validateGender(String gender) {
		if (gender.isEmpty()) {
			System.err.println("gender cannot be empty");
			return false;
		}
		if (gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("f")
				|| gender.equalsIgnoreCase("female")) {
			return true;
		} else
			System.err.println("enter correct gender");
		return false;
	}

	public boolean validateBalance(double balance) {
		if (balance > 0) {
			return true;
		} else
			System.err.println("Amount can't be negative");
		return false;
	}

	public boolean validateCustomerName(String customerName) {

		if (customerName.isEmpty()) {
			System.err.println("Name is mandatory field");
			return false;
		}
		for (int i = 0; i < 9; i++) {
			if (customerName.contains(Integer.toString(i))) {
				System.err.println("Name should not contain numbers");
				return false;
			}
		}
		if (customerName.contains("@")) {
			System.err.println("Name should not contain special charactes");
			return false;
		} else
			return true;
	}

}
