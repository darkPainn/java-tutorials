package com.sedat.databases;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * By using Java Database Connectivity(JDBC), we can work with databases, spreadsheets and flat files. JDBC acts as a middleman between the java application 
 * and the destination (db etc.). To use a particular data source in an application we need the JDBC driver for that source, such as sqlite JDBC driver.
 * The driver is simply a java library containing classes that implement the JDBC API, and because all JDBC drivers implement the same interfaces, it is not difficult to change
 * the data source of an application as you can just replace the driver with the new data source's driver.
 * 
 * JDBC consists of two packages: java.sql (core JDBC and is required when working with database servers) and javax.sql(optional JDBC).
 * 
 * Normally an application ships with the database, but sometimes you want to create the database when the application runs the first time.
 */
public class JDBCintroduction {

	public static void main(String[] args) throws IOException {
		
		/*all jdbc drivers needs a connection string to connect to a db which varies from driver to driver but they always start with jdbc:
		 * If the specified db doesn't exist, sqlite will create it in that directory
		 */
		String url = "jdbc:sqlite:C:\\Users\\sedat.turkoglu\\Documents\\workspaces\\java-tutorials\\src\\com\\sedat\\databases\\test.db";
		try {
			/**
			 * There are two ways of establishing a connection with a db
			 * 1- using a DriverManager
			 * 2- using data source objects, which is sometimes the preferred way,as it allows advanced features like connection pooling, and distributed transactions
			 * and it is also more portable because of the way the connections are established. It is much more complex to configure and only needed when working with
			 * large enterprise applications
			 * Whenever we use SQL with jdbc, we use what's called statement objects; so to create a table we are going to call conn.createStatement() method
			 * and we'll use statement.execute() to run the sql statement.
			 */
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();
			String sql = "create table if not exists contacts (name text, phone integer, email text)";
			statement.execute(sql);
			
			//it is important to close the connection, but you should close any statement instances before closing the conn
			statement.close();
			conn.close();
		}catch(SQLException e) {
			System.out.println("Something went wrong " + e.getMessage());
		}
		
	}

}


























