package com.capg.walletapp.service;

import com.capg.walletapp.bean.WalletApplication;

public interface IWalletApplicationService {

	public int createAcc(WalletApplication bean);
	public boolean login(String username, String password);
	public double showBal();
	public int deposit(double amount);
	public int withdraw(double amount);
	public int fundTransfer(long accNum, double amount);
	public WalletApplication printTrans(long tID);
	
}
