package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//WAJP to insert one single record by using statement interface
public class InsertRecord {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//Driver class is loaded and register
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			//connection is stablished
			stmt=con.createStatement();//Platform is created
			stmt.execute("insert into mydb.student values(5,'Akash',96319824)");
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
