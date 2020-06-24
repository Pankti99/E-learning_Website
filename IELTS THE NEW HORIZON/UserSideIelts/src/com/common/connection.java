package com.common;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class connection {
	private static String driverClassName = "com.mysql.jdbc.Driver";
	private static String connectionURL="jdbc:mysql://localhost:3306/ielts";
	private static String userName="root";
	private static String password="";
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(driverClassName);//Step 1 : Load The Driver
		
		    conn = DriverManager.getConnection(connectionURL, userName, password);//Step 3 : Esta. Connection
			
			
			if(conn!=null){
				System.out.println("Connected Whith DB..........");
				
			}else{
				System.out.println("Not Connected Whith DB..........");
				
			}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
		
	}
	
	public static void main(String[] args) {
		connection.getConnection();
	}
	
}

