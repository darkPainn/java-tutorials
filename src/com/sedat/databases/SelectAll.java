package com.sedat.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAll {

	public static void main(String[] args) {
		String url = "jdbc:sqlite:C:\\Users\\sedat.turkoglu\\Documents\\workspaces\\java-tutorials\\src\\com\\sedat\\databases\\test.db";
		try {
			Connection con = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			
			String slectAll = "select * from contacts";
			
			//executeQuery() returns a resultSet, use that instead of execute()
			ResultSet res = st.executeQuery(slectAll);
			while(res.next()) {
				System.out.println(res.getString("name") + " " +
						   res.getInt("phone") + " " + 
						   res.getString("email"));				
			}
			
			res.close();
			st.close();
			con.close();
			
		}catch(SQLException e) {
			System.out.println(e);
		}
	}

}
