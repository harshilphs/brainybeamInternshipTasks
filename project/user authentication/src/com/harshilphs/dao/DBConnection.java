package com.harshilphs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	static Connection conobj = null;
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/dbname";
		String user = "root";
		String passw = "";
		
		if(conobj == null) {	
		Class.forName("com.mysql.cj.jdbc.Driver");
		conobj = DriverManager.getConnection(url, user, passw);
		} else if(!conobj.isClosed()) {
			return conobj;
		} else {
			Class.forName("com.mysql.jdbc.Driver");
			conobj = DriverManager.getConnection(url, user, passw);
		}
		return conobj;
	}
}
