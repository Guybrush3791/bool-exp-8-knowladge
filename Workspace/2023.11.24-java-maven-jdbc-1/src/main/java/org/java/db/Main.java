package org.java.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {

	private static final String url = "jdbc:mysql://localhost:3306/db-aeroporto";
	private static final String user = "root";
	private static final String pws = "code";

	public static void main(String[] args) {
		
//		test1();
		test2();
	}

	private static void test2() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Numero posti minimo: ");
		
		String strMinSeatCount = sc.nextLine();
		int minSeatCount = Integer.valueOf(strMinSeatCount);
		
		try (Connection con = DriverManager.getConnection(url, user, pws)) {
			
			final String SQL = ""
					+ " SELECT * "
					+ " FROM airplanes "
					+ " WHERE seating_capacity > ?; ";
			
			try (PreparedStatement ps = con.prepareStatement(SQL)) {
				
				ps.setInt(1, minSeatCount);
				
				try (ResultSet rs = ps.executeQuery()) {
					
					int rowCounter = 0;
					while(rs.next()) {
						
						final String MANUFACTURER = rs.getString(2);
						final String MODEL = rs.getString(3);
						final int SEAT_CAPACITY = rs.getInt(4);
						
						System.out.println("[" + MODEL + "] " + MANUFACTURER 
								+ ": " + minSeatCount 
								+ "/" + SEAT_CAPACITY
								);
						
						rowCounter++;
					}
					
					System.out.println("\n------------------------------\n");
					System.out.println("Row count: " + rowCounter);
				}
			}
		} catch (Exception e) {
			
			System.out.println("Error in db: " + e.getMessage());
		}
	}
	private static void test1() {
		
		try (Connection con 
		      = DriverManager.getConnection(url, user, pws)) {  
		  
		  final String sql = " SELECT employees.id, employees.name, employees.lastname "
			  			   + " FROM employees "
			  			   + " ; ";		  
		  
		  try(PreparedStatement ps = con.prepareStatement(sql)){
		    try(ResultSet rs = ps.executeQuery()){
		    	
		    	while(rs.next()) {
		    		
		    		int id = rs.getInt(1);
		    		String name = rs.getString(2);
		    		String lastname = rs.getString(3);
		    		
		    		System.out.println("[" + id + "] " + name + " " + lastname);
		    	}
		    }
		  }
		} catch (Exception e) {
			
			System.out.println("Error in db: " + e.getMessage());
		}
	}
}
