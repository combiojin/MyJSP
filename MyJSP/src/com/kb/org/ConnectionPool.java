package com.kb.org;

import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;

public class ConnectionPool {
	
	private static Connection conn = null;
	
	public static Connection getcoConnection() {
		if (conn != null) {
			return conn;
		} else {
			try {
				Context initContext = (Context) new InitialContext().
				lookup("java:comp/env/");
				DataSource ds = (DataSource) initContext.lookup("jdbc/mysql");
				conn = ds.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return conn;
	}
}	
