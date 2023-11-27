package org.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static final String url = "jdbc:mysql://localhost:3306/db-nations";
	private static final String user = "root";
	private static final String pws = "code";
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Regione: ");
		String userSearchCountry = in.nextLine();
		
		try (Connection con = DriverManager.getConnection(url, user, pws)) {
			
			String sql = ""
					+ " SELECT countries.country_id 'countryId', countries.name 'country', regions.name 'region', continents.name 'continent' "
					+ " FROM countries "
					+ "    JOIN regions "
					+ "        ON countries.region_id = regions.region_id "
					+ "    JOIN continents "
					+ "        ON regions.continent_id = continents.continent_id "
					+ " WHERE countries.name LIKE ? "
					+ " ORDER BY countries.name; "
					;
			
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				
				ps.setString(1, "%" + userSearchCountry + "%");
				
				try (ResultSet rs = ps.executeQuery()) {
					
					while(rs.next()) {
						
						int regionId = rs.getInt(1);
						String region = rs.getString(2);
						String country = rs.getString(3);
						String continent = rs.getString(4);
						
						System.out.println("[" + regionId + "] " +
								region + " - " + country + " - " + continent);
					}
				}
			}
			
			System.out.print("Id country: ");
			String strUserIdCountry = in.nextLine();
			Integer userIdCountry = Integer.valueOf(strUserIdCountry);
			
			in.close();
			
			sql = ""
				+ " SELECT languages.language "
				+ "	FROM country_languages "
				+ "	    JOIN languages "
				+ "	        ON country_languages.language_id = languages.language_id "
				+ "	WHERE country_languages.country_id = ?; "
			;
			
			List<String> languages = new ArrayList<>();
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				
				ps.setInt(1, userIdCountry);
				
				try (ResultSet rs = ps.executeQuery()) {
				
					while(rs.next())
						languages.add(rs.getString(1));
				}
			}
			
			sql = ""
				+ " SELECT countries.name, country_stats.year, country_stats.population, country_stats.gdp "
				+ " FROM countries "
				+ "    JOIN country_stats "
				+ "        ON countries.country_id = country_stats.country_id "
				+ " WHERE countries.country_id = ? "
				+ " ORDER BY year DESC "
				+ " LIMIT 1; "
			;
			
			String countryName = null;
			Integer year = null;
			Long population = null;
			Long gdp = null;
			try (PreparedStatement ps = con.prepareStatement(sql)) {
				
				ps.setInt(1, userIdCountry);
				try (ResultSet rs = ps.executeQuery()) {
				
					while(rs.next()) {

						countryName = rs.getString(1);
						year = rs.getInt(2);
						population = rs.getLong(3);
						gdp = rs.getLong(4);
					}						
				}
			}
			
			System.out.println("Details for country: " + countryName);
			System.out.print("Languages: ");
			for (String l : languages) 
				System.out.print(l + ", ");
			
			System.out.println("\n");
			System.out.println("Most recent stats");
			System.out.println("Year: " + year);
			System.out.println("Population: " + population);
			System.out.println("GDP: " + gdp);
		} catch (Exception e) {
			
			System.out.println("Error conneting db: " + e.getMessage());
		}
	}
}
