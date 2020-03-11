package com.sedat.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertUpdateDelete {

	public static void main(String[] args) {
		String url = "jdbc:sqlite:C:\\Users\\sedat.turkoglu\\Documents\\workspaces\\java-tutorials\\src\\com\\sedat\\databases\\test.db";
		try {
			Connection con = DriverManager.getConnection(url);
			/*The default behavior of JDBC objects is to auto-commit all changes after a statement is executed and we don't need to commit or rolback explicitly.
			 * but you can turn off the auto-commit if you want. con.setAutoCommit(false);
			 */
			
			Statement statement = con.createStatement();
			statement.execute("create table if not exists contacts (name text, phone integer, email text)");
			
			//DELETE
			statement.execute("delete from contacts");
			
			//INSERT
			statement.execute("insert into contacts VALUES('john', 12345, 'john@test.com')");
			statement.execute("insert into contacts VALUES('doe', 12345, 'doe@test.com')");
			statement.execute("insert into contacts VALUES('pori', 12345, 'pori@test.com')");
			statement.execute("insert into contacts VALUES('tomm', 12345, 'tomm@test.com')");
			statement.execute("insert into contacts VALUES('peri', 12345, 'peri@test.com')");
			
			//UPDATE
			statement.execute("update contacts set phone=987465 where name='dummy2'");
			
			/**
			 * SELECT
			 * statement.execute returns a true if the statement we execute returns an instance of the resultset class, and false if it returned an
			 * update count or no result. when you run st.execute(update ....) then the result is the count of the number of rows that are updated.
			 * 
			 * When we query the database, the method returns the records that match the query as a result set instance. We can actually get the result set by calling 
			 * statement.getResultSet
			 * 
			 * A statement object ultimately can only have one active resultSet associated with it
			 */
			String selectAll = "SELECT * FROM contacts";
			statement.execute(selectAll);
			ResultSet result = statement.getResultSet();
			while(result.next()) {
				System.out.println(result.getString("name") + " " +
								   result.getInt("phone") + " " + 
								   result.getString("email"));
			}
			result.close();
			statement.close();
			con.close();
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		
	}

}















