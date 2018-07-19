package com.capg.walletapp.bean;

import java.time.LocalDate;

public class WalletApplication {

	private String customerName;
	private String username;
	private String password;
	private String email;
	private String contact;
	private int age;
	private String gender;
	private long accNum;
	private long tID;
	private LocalDate date;
	private double amount;
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
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
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "WalletApplication [customerName=" + customerName + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", contact=" + contact + ", age=" + age + ", gender=" + gender + ", accNum="
				+ accNum + ", tID=" + tID + ", date=" + date + ", amount=" + amount + "]";
	}
	
	
	
}
