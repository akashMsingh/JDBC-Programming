package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//WAJP to delete the record using statement interface
public class DeleteRecord {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		String query="Delete from mydb.student where id=5";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//Driver class is load and register
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			//Connection Stablished
			stmt=con.createStatement();
			stmt.executeUpdate(query);
			System.out.println("Record is Deleted..!!");
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
			if(stmt!=null) {
				try {
					stmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
