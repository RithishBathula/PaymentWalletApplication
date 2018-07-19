package com.capg.walletapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.capg.UtilConn.Util;
import com.capg.walletapp.bean.WalletApplication;
import com.capg.walletapp.exception.InsufficientBalanceException;
import com.capg.walletapp.exception.UserNotFound;

public class WalletApplicationDao implements IWalletApplicationDao {
	static ResultSet rs2, rs1, rs3;
	static Connection con;
	Connection con1;
	static long tID;

	public int createAcc(WalletApplication bean) {

		try {
			con1 = Util.getConnection();
			String insert = "insert into customer values(?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = con1.prepareStatement(insert);
			stmt.setString(1, bean.getCust().getCustomerName());
			stmt.setLong(2, bean.getCust().getAadharNum());
			stmt.setString(3, bean.getCust().getUsername());
			stmt.setString(4, bean.getCust().getPassword());
			stmt.setString(5, bean.getCust().getGender());
			stmt.setInt(6, bean.getCust().getAge());
			stmt.setString(7, bean.getCust().getContact());
			stmt.setString(8, bean.getCust().getEmail());
			int n1 = stmt.executeUpdate();

			String insert2 = "insert into walletApplication values(?,curdate(),?,?,?,?)";
			PreparedStatement stmt1 = con1.prepareStatement(insert2);
			stmt1.setLong(1, bean.getAccNum());
			stmt1.setDouble(2, bean.getBalance());
			stmt1.setString(3, bean.getBranch());
			stmt1.setString(4, bean.getAccType());
			stmt1.setLong(5, bean.getCust().getAadharNum());
			int n2 = stmt1.executeUpdate();
			if (n1 == 1 && n2 == 1) {
				return 1;
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				con1.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	public boolean login(String username, String password) {
		try {
			con = Util.getConnection();
			String select = "select * from customer where username='" + username + "' and password='" + password + "'";

			PreparedStatement stmt = con.prepareStatement(select);
			rs1 = stmt.executeQuery();

			if (rs1.first()) {
				int d = rs1.getInt(2);

				String select2 = "select * from walletapplication where aadharNo=" + d;
				PreparedStatement stmt1 = con.prepareStatement(select2);
				rs2 = stmt1.executeQuery();
				if (rs2.first()) {
					return true;
				}
			}

			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public double showBal() {

		try {
			// Connection con = Util.getConnection();
			System.out.println(rs2.first());
			if (rs2.first()) {
				return rs2.getDouble(3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public int deposit(double amount) {

		try {
			// Connection con = Util.getConnection();
			if (rs2.first()) {
				double d = rs2.getDouble(3) + amount;
				String update = "update walletapplication set balance=" + d + " where aadharNo='" + rs2.getLong(6)
						+ "'";
				PreparedStatement stmt = con.prepareStatement(update);
				if (stmt.executeUpdate() == 1) {
					tID = ((long) (Math.random() * 1234 + 9999));
					LocalDateTime date = LocalDateTime.now();
					String s = "TransactionID " + Long.toString(tID) + " at " + date.toString()
							+ "  and deposited amount is :" + Double.toString(amount);
					String insert="insert into transactions values("+rs2.getInt(6)+",'"+s+"')";
					PreparedStatement pst=con.prepareStatement(insert);
					pst.executeUpdate();
					System.out.println("Deposited successfully");
					int b = rs1.getInt(2);
					String select2 = "select * from walletapplication where aadharNo=" + b;
					PreparedStatement stmt1 = con.prepareStatement(select2);
					rs2 = stmt1.executeQuery();
					return 1;
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int withdraw(double amount) {

		try {
			// Connection con = Util.getConnection();
			if (rs2.first()) {
				double d = rs2.getDouble(3) - amount;
				String update = "update walletapplication set balance=" + d + " where aadharNo='" + rs2.getLong(6)
						+ "'";
				PreparedStatement stmt = con.prepareStatement(update);
				if (stmt.executeUpdate() == 1) {
					tID = ((long) (Math.random() * 1234 + 9999));
					LocalDateTime date = LocalDateTime.now();
					String s = "TransactionID " + Long.toString(tID) + " at " + date.toString()
							+ "  and withdrawn amount is :" + Double.toString(amount);
					String insert="insert into transactions values("+rs2.getInt(6)+",'"+s+"')";
					PreparedStatement pst=con.prepareStatement(insert);
					pst.executeUpdate();
					System.out.println("amount withdrawn successfully");
					int b = rs1.getInt(2);
					String select2 = "select * from walletapplication where aadharNo=" + b;
					PreparedStatement stmt1 = con.prepareStatement(select2);
					rs2 = stmt1.executeQuery();
					return 1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int fundTransfer(long accNum, double amount) {

		try {
			// Connection con = Util.getConnection();
			if (rs2.first()) {
				String select = "select * from walletapplication where accNum=" + accNum;
				PreparedStatement stmt1 = con.prepareStatement(select);
				rs3 = stmt1.executeQuery();
				if (rs3.first()) {

					double d1 = rs3.getDouble(3) + amount;
					String update = "update walletapplication set balance=" + d1 + " where aadharNo='" + rs3.getLong(6)
							+ "'";
					PreparedStatement stmt = con.prepareStatement(update);
					stmt.executeUpdate();

					double d = rs2.getDouble(3) - amount;
					String update1 = "update walletapplication set balance=" + d + " where aadharNo='" + rs2.getLong(6)
							+ "'";
					PreparedStatement stmt11 = con.prepareStatement(update1);
					if (stmt11.executeUpdate() == 1) {
						tID = ((long) (Math.random() * 1234 + 9999));
						LocalDateTime date = LocalDateTime.now();
						String s = "TransactionID " + Long.toString(tID) + " at " + date.toString()
								+ "  and transffered amount is :" + Double.toString(amount)+" to accountNumber: "+accNum;
						String insert="insert into transactions values("+rs2.getInt(6)+",'"+s+"')";
						PreparedStatement pst=con.prepareStatement(insert);
						pst.executeUpdate();
						System.out.println(amount + " amount debited from your account");
						int b = rs1.getInt(2);

						String select2 = "select * from walletapplication where aadharNo=" + b;
						PreparedStatement stmt2 = con.prepareStatement(select2);

						rs2 = stmt2.executeQuery();

					}
					return 1;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public void printTrans() {
		
		try {
			String select="select * from transactions where aadharNum="+rs2.getInt(6);
			PreparedStatement pst=con.prepareStatement(select);
			ResultSet rs4=pst.executeQuery();
			while(rs4.next()) {
				System.out.println(rs4.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void close() {

		try {
			con.close();
			System.out.println("Successfully loggedOut");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
