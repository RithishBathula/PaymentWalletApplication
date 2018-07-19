package com.capg.walletapp.bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WalletApplication {

	List<String> trans = new ArrayList();

	public List<String> getTrans() {
		return trans;
	}

	public void setTrans(List<String> trans) {
		this.trans = trans;
	}

	private long accNum;
	private long tID;
	private LocalDate date;
	private double balance;
	private String branch;
	private String iFSC;
	private Customer cust;

	public long getAccNum() {
		return accNum;
	}

	public void setAccNum(long accNum) {
		this.accNum = accNum;
	}

	public long gettID() {
		return tID;
	}

	public void settID(long tID) {
		this.tID = tID;
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

	public String getiFSC() {
		return iFSC;
	}

	public void setiFSC(String iFSC) {
		this.iFSC = iFSC;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	@Override
	public String toString() {
		return "WalletApplication [ accNum=" + accNum + ", tID=" + tID + ", date=" + date + ", balance=" + balance
				+ ", branch=" + branch + ", iFSC=" + iFSC + "]";
	}

}
