package com.tencent.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDbutil {
	
	static String url = "";
	static String user = "";
	static String password = "";
	static String drivername = "oracle.jdbc.driver.OracleDriver";
	
	public static Connection getConn() throws SQLException {
		try {
			Class.forName(drivername);
			} catch (ClassNotFoundException e) {
			System.out.println("The error message is : " + e.getMessage());
		}
		return DriverManager.getConnection(url,user,password);
	}
}

