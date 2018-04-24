package com.tencent.json;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import net.sf.json.JSONArray;

import com.tencent.model.HrData;
import com.tencent.util.OracleDB;
import com.tencent.util.OracleDbutil;

public class DBUtil {
	
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = OracleDbutil.getConn();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		String sql = "select * from tables";
		
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		 try {
			 pst = conn.prepareStatement(sql);
			 rs = pst.executeQuery();
			 while (rs.next()) {
				 HrData hr = (HrData) OracleDB.getFirstObjectFromRs(rs, HrData.class);
				 System.out.println(hr);
			 }
		 } catch(SQLException e) {
			 e.printStackTrace();
		 } finally {
			 OracleDB.closeRs(rs);
			 OracleDB.closePst(pst);
		 }
		 
		 try {
			 List<?> list = OracleDB.executeQuery(conn, sql, HrData.class);
			 System.out.println(list);
			 JSONArray json = JSONArray.fromObject(list);
			 System.out.println("----------------------------------------------------------------------");
			 System.out.println(json);
		 } catch(SQLException e) {
			 e.printStackTrace();
		 }
	}
	
	
	
	
}
