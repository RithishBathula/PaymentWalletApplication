package com.capg.walletapp.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.capg.walletapp.bean.WalletApplication;
import com.capg.walletapp.exception.InsufficientBalanceException;
import com.capg.walletapp.exception.UserNotFound;

public class WalletApplicationDao implements IWalletApplicationDao {

	static List<WalletApplication> list = new ArrayList<WalletApplication>();
	static WalletApplication temp = new WalletApplication();
	// static Map<String, Double> transactions=new HashMap();
	static long tID;

	public int createAcc(WalletApplication bean) {

		if (list.add(bean)) {

			return 1;
		} else
			return 0;
	}

	public boolean login(String username, String password) {
		Iterator<WalletApplication> it = list.iterator();

		while (it.hasNext()) {
			WalletApplication rec = it.next();
			if (rec.getCust().getUsername().equals(username) && rec.getCust().getPassword().equals(password)) {
				temp = rec;

				return true;
			}
		}
		return false;
	}

	public double showBal() {

		
		return temp.getBalance();
	}

	public int deposit(double amount) {

		Iterator<WalletApplication> it = list.iterator();

		while (it.hasNext()) {
			WalletApplication rec = it.next();
			if (rec.getCust().getUsername().equals(temp.getCust().getUsername())) {

				rec.setBalance(rec.getBalance() + amount);
				System.out.println("Amount deposited..present balance is :" + rec.getBalance());
				 //temp.setBalance(temp.getBalance() + amount);
				tID = ((long) (Math.random() * 1234 + 9999));
				LocalDateTime d = LocalDateTime.now();
				String s = "TransactionID " + Long.toString(tID) + " at " + d.toString() + " and deposited amount is :"
						+ Double.toString(amount);

				rec.getTrans().add(s);
				System.out.println("Amount deposited..present balance is :" + rec.getBalance());
				return 1;
			}
		}
		return 0;
	}

	public int withdraw(double amount) {

		Iterator<WalletApplication> it = list.iterator();
		while (it.hasNext()) {
			WalletApplication rec = it.next();
			if (rec.getCust().getUsername().equals(temp.getCust().getUsername())) {
				if (amount < temp.getBalance()) {
					rec.setBalance(rec.getBalance() - amount);
					// temp.setBalance(temp.getBalance() - amount);
					System.out.println("amount withdrawn..present bal  " + rec.getBalance());
					tID = ((long) (Math.random() * 1234 + 9999));
					LocalDateTime d = LocalDateTime.now();
					String s = "TransactionID " + Long.toString(tID) + " at " + d.toString()
							+ "  and withdrawn amount is :" + Double.toString(amount);

					rec.getTrans().add(s);
					return 1;
				} else {
					try {
						throw new InsufficientBalanceException();
					} catch (Exception e) {
						System.err.println("Insufficient balance in your account");
						e.printStackTrace();
					}
				}
			}
		}
		return 0;
	}

	public int fundTransfer(long accNum, double amount) {

		Iterator<WalletApplication> it = list.iterator();
		Iterator<WalletApplication> it1 = list.iterator();
		while (it.hasNext()) {
			WalletApplication rec = it.next();
			if (rec.getCust().getUsername().equals(temp.getCust().getUsername())) {

				while (it1.hasNext()) {

					WalletApplication rec1 = it1.next();
					if (rec1.getAccNum() == accNum) {
						if (amount < rec.getBalance()) {

							rec1.setBalance(rec1.getBalance() + amount);
							// temp.setBalance(temp.getBalance() - amount);
							rec.setBalance(rec.getBalance() - amount);
							tID = ((long) (Math.random() * 1234 + 9999));
							LocalDateTime d = LocalDateTime.now();
							String s = "TransactionID " + Long.toString(tID) + " at " + d.toString()
									+ " and transferred amount is :" + Double.toString(amount);

							rec.getTrans().add(s);
							System.out.println("Balance after transferring in  " + rec.getCust().getCustomerName()
									+ " is " + rec.getBalance());
							System.out.println("Balance after receiving amount in " + rec1.getCust().getCustomerName()
									+ " is " + rec1.getBalance());
							return 1;
						} else {
							System.out.println("Insufficient balance in your account");
						}

					} else {
						try {
							throw new UserNotFound();
						} catch (Exception e) {
							System.err.println("Account not found");
							e.printStackTrace();
						}
					}
				}
			}
		}
		return 0;
	}

	public List printTrans() {

		Iterator<WalletApplication> it = list.iterator();

		while (it.hasNext()) {
			WalletApplication rec = it.next();
			if (rec.getCust().getUsername().equals(temp.getCust().getUsername())) {
				return rec.getTrans();
			}

		}
		return null;
	}
}
