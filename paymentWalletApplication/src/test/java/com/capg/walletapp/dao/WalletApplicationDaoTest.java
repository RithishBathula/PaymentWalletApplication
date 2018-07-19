package com.capg.walletapp.dao;

import com.capg.walletapp.bean.WalletApplication;

import junit.framework.TestCase;

public class WalletApplicationDaoTest extends TestCase {

	WalletApplicationDao dao = new WalletApplicationDao();
	WalletApplication bean = new WalletApplication();

	public void testCreateAcc() {
		assertEquals(1, dao.createAcc(bean));
		assertNotNull(bean);
		assertTrue(true);
	}

	public void testLogin() {
		assertEquals(true, dao.login("rithish","12345678"));
		assertTrue(true);
	}

	public void testShowBal() {
		assertEquals(2000, 2000);
		assertNotNull(dao.showBal());

	}

	public void testDeposit() {
		bean.setBalance(10000);
		assertEquals(1, dao.deposit(bean.getBalance()));
		assertTrue(true);
	}

	public void testWithdraw() {
		bean.setBalance(500);
		assertEquals(1, dao.deposit(bean.getBalance()));
		assertTrue(true);
	}

	public void testFundTransfer() {
		assertEquals(1, dao.fundTransfer(bean.getAccNum(), bean.getBalance()));
		assertTrue(true);
	}

	public void testPrintTrans() {
		assertEquals(null, dao.printTrans());
		// assertNotNull(dao.printTrans(bean.gettID()));
	}

}
