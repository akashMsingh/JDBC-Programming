package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//WAJP to create platform by using statement interface 
public class CreatePlatfrom {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//Driver class is loaded
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			//connection is stablished between java application and database server
			stmt=con.createStatement();//Platform is created
			System.out.println("platform is created ");
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
