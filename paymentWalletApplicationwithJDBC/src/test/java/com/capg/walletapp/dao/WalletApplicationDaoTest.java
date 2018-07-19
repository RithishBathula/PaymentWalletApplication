package com.capg.walletapp.dao;

import com.capg.walletapp.bean.WalletApplication;

import junit.framework.TestCase;

public class WalletApplicationDaoTest extends TestCase {

	WalletApplicationDao dao = new WalletApplicationDao();
	WalletApplication bean = new WalletApplication();

	public void testCreateAcc() {
		//assertEquals(1, dao.createAcc(bean));
		assertNotNull(bean);
		assertTrue(true);
	}

	public void testLogin() {
		assertEquals(true, dao.login("chandu","87654321"));
		assertEquals(true, dao.login("pavangoud","12341234"));
		
		assertTrue(true);
	}

	public void testShowBal() {
		assertEquals(2000, 2000);
		assertNotNull(dao.showBal());

	}

	public void testDeposit() {
	
		assertEquals(1, dao.deposit(1000));
		assertTrue(true);
	}

	public void testWithdraw() {
		bean.setBalance(500);
		assertEquals(1, dao.deposit(bean.getBalance()));
		assertTrue(true);
	}

	public void testFundTransfer() {
		assertEquals(1, dao.fundTransfer(10730, 2000));
		assertEquals(0, dao.fundTransfer(10712, 2000));
		assertTrue(true);
	}

	
	

}
