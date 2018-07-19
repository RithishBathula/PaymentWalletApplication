package com.capg.walletapp.dao;

import java.util.List;
import java.util.Map;

import com.capg.walletapp.bean.WalletApplication;

public interface IWalletApplicationDao {

	public int createAcc(WalletApplication bean);
	public boolean login(String username, String password);
	public double showBal();
	public int deposit(double amount);
	public int withdraw(double amount);
	public int fundTransfer(long accNum, double amount);
	public List<String> printTrans();
	
}
