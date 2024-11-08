package com.jdbc;
//WAJP to Load And Register the Driver class
public class LoadAndRegisterDriver {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class is loaded and regitered");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
