package com.capg.walletapp.service;

import java.util.List;

import com.capg.walletapp.bean.WalletApplication;
import com.capg.walletapp.dao.WalletApplicationDao;

public class WalletApplicationService implements IWalletApplicationService {

	WalletApplicationDao dao = new WalletApplicationDao();

	public int createAcc(WalletApplication details) {

		return dao.createAcc(details);
	}

	public boolean login(String username, String password) {

		return dao.login(username, password);
	}

	public double showBal() {
		// TODO Auto-generated method stub
		return dao.showBal();
	}

	public int deposit(double amount) {
		// TODO Auto-generated method stub
		return dao.deposit(amount);
	}

	public int withdraw(double amount) {
		// TODO Auto-generated method stub
		return dao.withdraw(amount);
	}

	public int fundTransfer(long accNum, double amount) {
		// TODO Auto-generated method stub
		return dao.fundTransfer(accNum, amount);
	}

	public List<String> printTrans() {
		// TODO Auto-generated method stub
		return dao.printTrans();
	}

}
