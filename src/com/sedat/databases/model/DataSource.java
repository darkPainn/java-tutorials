package com.sedat.databases.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
	
	public static final String DB_NAME = "music.db";
	public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\sedat.turkoglu\\Documents\\workspaces\\java-tutorials\\src\\com\\sedat\\databases\\" + DB_NAME;
	
	public static final String TABLE_ALBUMS = "albums";
	public static final String COLUMN_ALBUM_ID = "_id";
	public static final String COLUMN_ALBUM_NAME = "name";
	public static final String COLUMN_ALBUM_ARTIST = "artist";
	
	public static final String TABLE_ARTISTS = "artists";
	public static final String COLUMN_ARTISTS_ID = "_id";
	public static final String COLUMN_ARTISTS_NAME = "name";
	//use those indexes for table columns to retrieve the data they hold for each field result.getString(columnIndex) instead of result.getString("name")
	//on the latter the the string literal "name" needs to match the column name and a comparison is made to check which takes up resources.
	private static final int INDEX_ARTISTS_ID = 1;
	private static final int INDEX_ARTISTS_NAME = 2;
	
	public static final String TABLE_SONGS = "songs";
	public static final String COLUMN_SONGS_ID = "_id";
	public static final String COLUMN_SONGS_TRACK = "track";
	public static final String COLUMN_SONGS_TITLE = "title";
	public static final String COLUMN_SONGS_ALBUM = "album";
	private Connection conn;
	
	public boolean open() {
		try {
			conn = DriverManager.getConnection(CONNECTION_STRING);
			return true;
		}catch(SQLException e) {
			System.out.println(e);
			return false;
		}
	}
	
	public void close() {
		try {
			if(conn != null) {
				conn.close();
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	public List<Artist> queryArtists(){
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from " + TABLE_ARTISTS);
			//once you have the resultset, you can have access to its metadata such as columns etc.
			ResultSetMetaData metadata = rs.getMetaData();
			System.out.println("katalog name: " + metadata.getCatalogName(1));
			List<Artist> artists = new ArrayList<>();
			while(rs.next()) {
				Artist temp = new Artist();
				temp.setId(rs.getInt(INDEX_ARTISTS_ID));
				temp.setName(rs.getString(INDEX_ARTISTS_NAME));
				artists.add(temp);
			}
			return artists;
		}catch(SQLException e) {
			System.out.println(e);
			return null;
		}finally {
			try {
				st.close();
			}catch(SQLException ex) {
				System.out.println("couldn't close the statement");
			}
		}
	}
	
	public int getCount(String table) {
		String sql = "select count(*) from " + table;
		try(Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql)){
			return rs.getInt(1);
		}catch(SQLException e) {
			System.out.println(e);
			return -1;
		}
	}
}























 