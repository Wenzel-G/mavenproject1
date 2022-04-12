package com.quintrix.mavenproject1.mavenproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestingJDBC {
	
	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/movies_watched?useSSL=false&serverTimezone=UTC";
		String user = "testing";
		String pass = "testing";
		
		
		try {
			
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection myConnection = DriverManager.getConnection(jdbcUrl, user,pass);
			
			System.out.println("Connection successful");
			
			
			Statement statement = myConnection.createStatement();
			
//			statement.execute("INSERT INTO movies " + "VALUES (1, 'Django Unchained', 'Action', 12 )");
//			statement.execute("INSERT INTO movies " + "VALUES (2, 'The Hateful Eight', 'Action', 50 )");
//			statement.execute("INSERT INTO movies " + "VALUES (3, 'Friday', 'Comedy', 2 )");
			
			ResultSet rs = statement.executeQuery("SELECT movie_name from movies WHERE times_watched > 10");
			
			while (rs.next()) {
				String movieName = rs.getString("movie_name");
				System.out.println(movieName);
			}
			
			statement.executeUpdate("UPDATE movies SET times_watched=5 WHERE movie_name='Friday'");
			
			rs = statement.executeQuery("SELECT * FROM movies");
			
			while(rs.next()) {
				System.out.println(rs.getString("movie_name") + " has been watched " + rs.getInt("times_watched") + " times");
			}
			
			
			myConnection.close();
		} catch (Exception exc) {
			exc.printStackTrace();		
			}
		
	}

}
