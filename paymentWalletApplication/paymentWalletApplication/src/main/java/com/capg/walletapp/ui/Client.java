package com.capg.walletapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {
	
	public static void createAccount() {
		// TODO Auto-generated method stub
		
	}

	public static void showBalance() {
		// TODO Auto-generated method stub
		
	}
	private static void withdrawAmount() {
		// TODO Auto-generated method stub
		
	}

	private static void depositAmount() {
		// TODO Auto-generated method stub
		
	}
	private static void printTransaction() {
		// TODO Auto-generated method stub
		
	}

	private static void fundTransfer() {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("*****Welcome to XYZ Bank");
		System.out.println("1. Create Account");
		System.out.println("2. Show Balance");
		System.out.println("3. Deposit");
		System.out.println("4. Withdraw");
		System.out.println("5. FundTransfer");
		System.out.println("6. Print Transaction ");
		System.out.println("Enter your choice ");
		try {
			int key=Integer.parseInt(br.readLine());
			switch (key) {
			case 1:
				createAccount();
				break;
			case 2:
				showBalance();
				break;
			case 3:
				depositAmount();
				break;
			case 4:
				withdrawAmount();
			case 5:
				fundTransfer();
				break;
			case 6:
				printTransaction();
				break;
			default:
				break;
			}
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

	

	

	

}
