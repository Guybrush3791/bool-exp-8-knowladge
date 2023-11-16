package org.java;

import java.time.LocalDate;

import org.java.pojo.Boss;
import org.java.pojo.Employee;
import org.java.pojo.abs.Worker;

public class Main {

	public static void main(String[] args) {
		
//		Worker w1 = new Worker("Guybrush", "Threepwood", 
//				LocalDate.parse("1989-11-15"));
		
//		System.out.println(w1);
//		System.out.println("\n--------------------------------\n");
		
		Employee e1 = new Employee("Marco", "Rossi", 
				LocalDate.parse("1991-01-15"), 2200, 14);
		
		System.out.println(e1);
		System.out.println("\n--------------------------------\n");
		
		Boss b1 = new Boss("Francesca", "Bianchi", 
				LocalDate.parse("1998-01-15"), 5000, 10000);
		
		System.out.println(b1);
		System.out.println("\n--------------------------------\n");
		
		int yearSalarySum = e1.getYearSalary() + b1.getYearSalary();
		System.out.println("Sum year salary: " + yearSalarySum);
		System.out.println("\n--------------------------------\n");
		
		Worker[] workers = new Worker[2];
		workers[0] = e1;
		workers[1] = b1;
//		workers[2] = w1;
		
		yearSalarySum = 0;
		for (int x=0;x<workers.length;x++) {
			
			Worker w = workers[x];
			
//			if (w instanceof Employee) {
//				
//				Employee e = (Employee) w;
//				yearSalarySum += e.getYearSalary();
//			}
			
			yearSalarySum += w.getYearSalary();
		}
		System.out.println("Sum year salary: " + yearSalarySum);
	}
}
