package com.capg.walletapp.bean;

public class Customer {

	private String customerName;
	private String username;
	private String password;
	private String email;
	private String contact;
	private int age;
	private String gender;
	private long aadharNum;
	
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getAadharNum() {
		return aadharNum;
	}
	public void setAadharNum(long aadharNum) {
		this.aadharNum = aadharNum;
	}

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", contact=" + contact + ", age=" + age + ", gender=" + gender + ", aadharNum="
				+ aadharNum +  "]";
	}
	
	
	
}
