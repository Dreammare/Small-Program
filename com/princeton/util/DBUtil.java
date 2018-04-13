package com.princeton.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	
	public static Connection conn = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;
	
	private DBUtil(){
	}
	
	public static Connection getConnection() {
		PropertiesUtil.loadFile("./resource/config.properties");
		String user = PropertiesUtil.getPropertyValue("user");
		String password = PropertiesUtil.getPropertyValue("password");
		String url = PropertiesUtil.getPropertyValue("url");
		String driver = PropertiesUtil.getPropertyValue("driver");
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password); 
			System.out.println("Connect Success");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		if (conn == null) {
			System.out.println("error");
		}
		return conn;
	}
	
	public static void select() {
		try {
			String sql = "select year, period, account, entity, code, amount from test";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			
			System.out.println("year"+"\t"+"period"+"\t"+"account"+"\t"+"entity"+"\t"+"code"+"\t"+"amount"+"\t");
			while (rs.next()) {
				System.out.print(rs.getString(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getString(4)+"\t");
				System.out.print(rs.getString(5)+"\t");
				System.out.print(rs.getDouble(6)+"\t");
				System.out.println();
			}
		} catch(SQLException se) {
			se.printStackTrace();
		} finally {
			System.out.println("Closed the connection");
			try{
				rs.close();
				pstmt.close();
				conn.close();
			} catch(SQLException e) {
				System.out.println("Can't connection the database");
			}
		}
	}
	
	
	public static void main(String[] args) {
		getConnection();
		select();
	}
	
}
