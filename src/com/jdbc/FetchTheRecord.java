package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//WAJP to fetch the record by using statement interface
public class FetchTheRecord {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		String query="select * from mydb.student";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//Driver class is loaded and register
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			//Connection is stablished
			stmt=con.createStatement();//Statement is created
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
			}
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
