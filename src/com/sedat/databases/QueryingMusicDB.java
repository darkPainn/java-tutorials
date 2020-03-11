package com.sedat.databases;

import java.util.List;

import com.sedat.databases.model.Artist;
import com.sedat.databases.model.DataSource;

public class QueryingMusicDB {

	public static void main(String[] args) {
		
		DataSource datasource = new DataSource();
		
		if(!datasource.open()) {
			System.out.println("Cannot open the data source");
			return;
		}
		List<Artist> ar = datasource.queryArtists();
		for(Artist a : ar) {
			System.out.println("ID: " + a.getId() + " NAME: " + a.getName());
		}
		System.out.println(datasource.getCount("artists"));
		datasource.close();
	}

}
