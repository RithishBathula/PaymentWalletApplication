package com.capg.walletapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.capg.walletapp.bean.Customer;
import com.capg.walletapp.bean.WalletApplication;
import com.capg.walletapp.exception.UserNotFound;
import com.capg.walletapp.service.ApplicationDataValidate;
import com.capg.walletapp.service.WalletApplicationService;

public class Client {
	static int choice, flag, key;

	public static void createAccount() {

		WalletApplicationService service = new WalletApplicationService();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter your name: ");
		try {
			String customerName = br.readLine();

			System.out.println("Enter UserName: ");
			String username = br.readLine();

			System.out.println("Set your password: ");
			String password = br.readLine();

			System.out.println("Enter your mail ID: ");
			String email = br.readLine();

			System.out.println("Enter your phone number: ");
			String contact = br.readLine();

			System.out.println("Enter your age: ");
			int age = Integer.parseInt(br.readLine());

			System.out.println("Enter your gender: ");
			String gender = br.readLine();

			System.out.println("Enter minimum mount balance");
			double balance = Double.parseDouble(br.readLine());

			long accNum = (long) (Math.random() * 1234 + 9999);

			Customer details = new Customer();

			WalletApplication bean = new WalletApplication();

			details.setCustomerName(customerName);
			details.setUsername(username);
			details.setPassword(password);
			details.setEmail(email);
			details.setContact(contact);
			details.setAge(age);
			details.setGender(gender);

			bean.setAccNum(accNum);
			bean.setBalance(balance);
			bean.setCust(details);
			bean.setiFSC("1AZ23D");
			bean.setBranch("Financial District Branch");

			ApplicationDataValidate validate = new ApplicationDataValidate();
			boolean isValidName = validate.validateCustomerName(customerName);
			boolean isValidUsername = validate.validateUsername(username);
			boolean isValidPassword = validate.validatePassword(password);
			boolean isValidEmail = validate.validateMail(email);
			boolean isValidContact = validate.validateContact(contact);
			boolean isValidAge = validate.validateAge(age);
			boolean isValidGender = validate.validateGender(gender);
			boolean isValidBalance = validate.validateBalance(balance);

			if (isValidName && isValidUsername && isValidPassword && isValidEmail && isValidContact && isValidAge
					&& isValidGender && isValidBalance) {
				flag = service.createAcc(bean);
			}
			if (flag == 1) {
				System.out.println("Account created successfully with accNum  :" + accNum);
				System.out.println("IFSC  :"+bean.getiFSC());
				System.out.println("Branch  :"+bean.getBranch());
			} else
				System.out.println("failed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void loginAcc() {

		WalletApplicationService service = new WalletApplicationService();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter UserName: ");
		String username;
		try {
			username = br.readLine();
			System.out.println("Set your password: ");
			String password = br.readLine();
			if (service.login(username, password)) {
				System.out.println("login successfull");
				do {
					System.out.println("1. Show Balance");
					System.out.println("2. Deposit");
					System.out.println("3. Withdraw");
					System.out.println("4. FundTransfer");
					System.out.println("5. Print Transaction ");
					System.out.println("6. Exit ");
					System.out.println("Enter your choice ");

					key = Integer.parseInt(br.readLine());
					switch (key) {

					case 1:
						showBalance();
						break;
					case 2:
						depositAmount();
						break;
					case 3:
						withdrawAmount();
						break;
					case 4:
						fundTransfer();
						break;
					case 5:
						printTransaction();
						break;
					case 6:
						System.out.println("thankyou");
						main();
					default:
						break;
					}
				} while (key != 7);
			} else {
				try {
					throw new UserNotFound();
				} catch (Exception e) {
					System.err.println("login failed");
					e.printStackTrace();
				}
				
			}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void showBalance() {

		WalletApplicationService service = new WalletApplicationService();
		double bal = service.showBal();
		System.out.println("Balance :" + bal);
	}

	private static void withdrawAmount() {

		WalletApplicationService service = new WalletApplicationService();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ApplicationDataValidate validate = new ApplicationDataValidate();
		System.out.println("Enter amount to withdraw");
		double amount;
		try {
			amount = Double.parseDouble(br.readLine());
			boolean isValidBalance = validate.validateBalance(amount);
			service.withdraw(amount);

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void depositAmount() {

		WalletApplicationService service = new WalletApplicationService();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ApplicationDataValidate validate = new ApplicationDataValidate();
		System.out.println("Enter amount to deposit");
		double amount;
		try {
			amount = Double.parseDouble(br.readLine());
			boolean isValidBalance = validate.validateBalance(amount);
			service.deposit(amount);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void printTransaction() {

		WalletApplicationService service = new WalletApplicationService();

		System.out.println(service.printTrans() + "\n");

	}

	private static void fundTransfer() {

		WalletApplicationService service = new WalletApplicationService();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ApplicationDataValidate validate = new ApplicationDataValidate();

		System.out.println("Enter receiver's accNum ");
		try {
			long accNum = Long.parseLong(br.readLine());
			System.out.println("Enter amound to transfer :");
			double amount = Double.parseDouble(br.readLine());
			int trans = service.fundTransfer(accNum, amount);
			if (trans == 1) {
				System.out.println("FundTransfer Successfull");
			} else {
				System.out.println("Enter valid accNum");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		main();
	}

	public static void main() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.println("*****Welcome to XYZ Bank*****");
			System.out.println("1. Create Account");
			System.out.println("2. login");
			System.out.println("3. Exit");
			try {
				choice = Integer.parseInt(br.readLine());
				switch (choice) {
				case 1:
					createAccount();
					break;
				case 2:
					loginAcc();
					break;
				case 3:
					System.out.println("ThankYou");
					System.exit(0);
				default:
					System.out.println("enter valid choice");
					break;
				}

			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} while (choice != 3);

	}

}
