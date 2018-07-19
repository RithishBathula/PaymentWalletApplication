package com.capg.UtilConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

	public static Connection getConnection() throws ClassNotFoundException,SQLException{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/wallet","root","Capgemini@123");
		
		return conn;
	}	
}
