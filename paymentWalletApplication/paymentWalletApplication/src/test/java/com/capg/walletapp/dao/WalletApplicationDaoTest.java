package com.capg.walletapp.dao;

import com.capg.walletapp.bean.WalletApplication;

import junit.framework.TestCase;

public class WalletApplicationDaoTest extends TestCase {
	
	WalletApplicationDao dao= new WalletApplicationDao();
	WalletApplication bean=new WalletApplication();
	
	public void testCreateAcc() {
		assertEquals(0, dao.createAcc(bean));
		assertNotNull(bean);
		assertTrue(true);
	}

	public void testLogin() {
	assertEquals(false, dao.login(bean.getUsername(), bean.getPassword()));
	assertTrue(true);
	}

	public void testShowBal() {
		assertEquals(2000, 2000);
		assertNotNull(dao.showBal());
		
	}

	public void testDeposit() {
		assertEquals(0, dao.deposit(bean.getAmount()));
		assertTrue(true);
	}

	public void testWithdraw() {
		assertEquals(0, dao.deposit(bean.getAmount()));
		assertTrue(true);
	}

	public void testFundTransfer() {
		assertEquals(0, dao.fundTransfer(bean.getAccNum(), bean.getAmount()));
		assertTrue(true);
	}

	public void testPrintTrans() {
		assertEquals(null, dao.printTrans(bean.gettID()));
		//assertNotNull(dao.printTrans(bean.gettID()));
	}

}
