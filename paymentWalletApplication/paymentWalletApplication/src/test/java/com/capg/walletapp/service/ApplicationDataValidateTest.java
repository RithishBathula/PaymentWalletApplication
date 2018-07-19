package com.capg.walletapp.service;

import com.capg.walletapp.bean.WalletApplication;

import junit.framework.TestCase;

public class ApplicationDataValidateTest extends TestCase {

	WalletApplication bean=new WalletApplication();
	ApplicationDataValidate validate=new ApplicationDataValidate();
	
	public void testValidateAge() {
		bean.setAge(15);
		assertNotNull(bean.getAge());
	   assertEquals(false, validate.validateAge(bean.getAge()));
	}

	public void testValidateMail() {
		bean.setEmail("rithish@gmail.com");
		assertNotNull(bean.getEmail());
		assertEquals(false, validate.validateMail(bean.getEmail()));
	}

	public void testValidateUsername() {
		bean.setUsername("rithish");
	assertNotNull(bean.getUsername());
	assertEquals(false, validate.validateUsername(bean.getUsername()));
	}

	public void testValidatePassword() {
		bean.setPassword("54321");
		assertNotNull(bean.getPassword());
		assertEquals(false, validate.validatePassword(bean.getPassword()));
	}

	public void testValidateContact() {
		bean.setContact("9876543212");
	    assertNotNull(bean.getContact());
	    assertEquals(false, validate.validateContact(bean.getContact()));
	}

	public void testValidateGender() {
		bean.setGender("male");
		assertNotNull(bean.getGender());
		assertEquals(false, validate.validateGender(bean.getGender()));
	}

	public void testValidateAmount() {
		bean.setAmount(5000);
		assertNotNull(bean.getAmount());
		assertEquals(false, validate.validateAmount(bean.getAmount()));
	}

	public void testValidateCustomerName() {
		bean.setCustomerName("rithish");
		assertNotNull(bean.getCustomerName());
		assertEquals(false, validate.validateCustomerName(bean.getCustomerName()));
	}

}
