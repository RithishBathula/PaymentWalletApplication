package com.capg.walletapp.bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WalletApplication {

//	List<String> trans = new ArrayList();
//
//	public List<String> getTrans() {
//		return trans;
//	}
//
//	public void setTrans(List<String> trans) {
//		this.trans = trans;
//	}

	private long accNum;

	private LocalDate date;
	private double balance;
	private String branch;
	private String accType; 
	private Customer cust;
	private long AadharNum;

	public long getAccNum() {
		return accNum;
	}

	public void setAccNum(long accNum) {
		this.accNum = accNum;
	}


	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}



	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	@Override
	public String toString() {
		return "WalletApplication  , accNum=" + accNum + ", date=" + date + ", balance=" + balance
				+ ", branch=" + branch + ", accType=" + accType + ", cust=" + cust + ", AadharNum=" + AadharNum + "]";
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public long getAadharNum() {
		return AadharNum;
	}

	public void setAadharNum(long aadharNum) {
		
		AadharNum = cust.getAadharNum();
	}

}
