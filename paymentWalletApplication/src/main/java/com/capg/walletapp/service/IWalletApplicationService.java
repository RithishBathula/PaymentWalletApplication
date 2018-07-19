package com.capg.walletapp.service;

import java.util.List;

import com.capg.walletapp.bean.WalletApplication;

public interface IWalletApplicationService {

	public int createAcc(WalletApplication bean);
	public boolean login(String username, String password);
	public double showBal();
	public int deposit(double amount);
	public int withdraw(double amount);
	public int fundTransfer(long accNum, double amount);
	public List<String> printTrans();
	
}
