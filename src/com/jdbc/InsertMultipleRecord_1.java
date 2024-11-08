package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//WAJP to insert multiple record by using placeholder
public class InsertMultipleRecord_1 {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String query="insert into mydb.student values(?,?,?)";//DML
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//Driver class is loaded and register
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			//Connection is stablished
			pstmt=con.prepareStatement(query); //Compilation---1
			
			//set the data for placeholder
			pstmt.setInt(1, 9);
			pstmt.setString(2, "Amit");
			pstmt.setInt(3, 99887766);
			pstmt.executeUpdate();//Executed--1
			
			pstmt.setInt(1, 10);
			pstmt.setString(2, "Chandan");
			pstmt.setInt(3, 76548484);
			pstmt.executeUpdate();//Executed--2
			System.out.println("Record is inserted");
		}catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
