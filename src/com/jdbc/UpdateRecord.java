package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//WAJP to update the record using executeUpdate() method
public class UpdateRecord {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		String query = "UPDATE mydb.student SET name = 'prince' WHERE id = 1";
;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//Driver class is loaded and register
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			//Connection is stablished
			stmt=con.createStatement();//Platform is created
			stmt.executeUpdate(query);
			System.out.println("Record is Updated");
		}catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
