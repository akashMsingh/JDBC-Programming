package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//WAJP to insert the multiple record using executeUpdate() method
public class InsertMultipalRecord {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		String query1="insert into mydb.student values(5,'Laddu',93413921)";
		String query2="insert into mydb.student values(6,'Pryesh',9876543)";
		String query3="insert into mydb.student values(7,'Manya',7654321)";
		String query4="insert into mydb.student values(8,'Monu',6655432)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//Driver class is loaded and register
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			//Connection is stablished
			stmt=con.createStatement();//Statement is Created
			stmt.executeUpdate(query1);
			stmt.executeUpdate(query2);
			stmt.executeUpdate(query3);
			stmt.executeUpdate(query4);
			System.out.println("Multiple record is updated");
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
