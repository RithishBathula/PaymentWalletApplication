package com.capg.walletapp.service;

import com.capg.walletapp.bean.WalletApplication;

import junit.framework.TestCase;

public class ApplicationDataValidateTest extends TestCase {

	WalletApplication bean = new WalletApplication();
	ApplicationDataValidate validate = new ApplicationDataValidate();

	public void testValidateAge() {

		assertEquals(true, validate.validateAge(21));
		assertEquals(false, validate.validateAge(10));

	}

	public void testValidateMail() {

		assertEquals(true, validate.validateMail("rithish@gmail.com"));
		assertEquals(false, validate.validateMail("rithish@gmail"));
		assertEquals(false, validate.validateMail(""));
	}

	public void testValidateUsername() {

		assertEquals(true, validate.validateUsername("rithish"));
		assertEquals(false, validate.validateUsername(" rithish"));
		assertEquals(false, validate.validateUsername(""));
	}

	public void testValidatePassword() {

		assertEquals(true, validate.validatePassword("12345678"));
		assertEquals(false, validate.validatePassword("123"));
		assertEquals(false, validate.validatePassword(" 1235678"));
		assertEquals(false, validate.validatePassword(""));
	}

	public void testValidateContact() {

		assertEquals(true, validate.validateContact("9876543212"));
		assertEquals(false, validate.validateContact("987652"));
		assertEquals(false, validate.validateContact(""));
	}

	public void testValidateGender() {

		assertEquals(true, validate.validateGender("male"));
		assertEquals(true, validate.validateGender("m"));
		assertEquals(true, validate.validateGender("female"));
		assertEquals(true, validate.validateGender("f"));
		assertEquals(false, validate.validateGender("ma3"));
	}

	public void testValidateAmount() {

		assertEquals(true, validate.validateBalance(123));
		assertEquals(false, validate.validateBalance(-123));
	}

	public void testValidateCustomerName() {

		assertEquals(true, validate.validateCustomerName("rithish"));
		assertEquals(false, validate.validateCustomerName("7rithish"));
		assertEquals(false, validate.validateCustomerName("@rithish"));
		assertEquals(false, validate.validateCustomerName(""));
	}

}
