package com.sedat.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author sedat.turkoglu
 * PreparedStatements can protect against SQL injection attacks because when we use them we don't concatenate raw user input into 
 * SQL statement that we will be running.
 * PreparedStatements are like place holders in SQL statements for the values that change from query to query. 
 */
public class SQLInjectionAttacksAndPreparedStatements {

	public static void main(String[] args) {
		
		String url = "jdbc:sqlite:C:\\Users\\sedat.turkoglu\\Documents\\workspaces\\java-tutorials\\src\\com\\sedat\\databases\\music.db";
		PreparedStatement st = null;
		Scanner sc = new Scanner(System.in);
		
		//the ? is the placeholder character we use for prepared statements and when we are ready to run the query, we will replace it with actual value
		//the protection comes from the fact that the replaced value is interpreted as literal value and cannot be interpreted as sql commands
		String sql = "select * from songs where title = ?";
		
		try {
			Connection con = DriverManager.getConnection(url);
			st = con.prepareStatement(sql);
			System.out.println("type the title of the song");
			String title = sc.nextLine();
			
			st.setString(1, title);
			ResultSet res = st.executeQuery();
			while(res.next()) {
				System.out.println("ID: " + res.getInt(1) + " track: " + res.getInt(2) + " album " + res.getString(3) );
			}
			sc.close();
			st.close();
			con.close();
			
		}catch(SQLException e) {
			System.out.println(e);
		}		
		
	}

}
