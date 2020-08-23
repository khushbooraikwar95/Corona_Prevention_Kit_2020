package com.wf.corona.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory {
	
	private static DataSource datasource;
	
	public static Connection getConnection() throws SQLException {
		
		if(datasource==null) {			
			try {
				InitialContext context = new InitialContext();
				datasource = (DataSource)context.lookup("java:/comp/env/jdbc/MyDB");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		
		return datasource.getConnection();
	}
}
