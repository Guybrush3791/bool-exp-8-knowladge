package org.java;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.java.helper.Helper;
import org.java.pojo.Concerto;
import org.java.pojo.Evento;

public class Main {

	public static void main(String[] args) {
		
//		milestone2();
//		milestone3();
		milestone4();
	}
	
	public static void milestone4() {
		
		ProgrammaEventi pe = new ProgrammaEventi("My program");
		
		try {
			Evento e1 = new Evento("evento 1", LocalDate.now().plusDays(4), 100);
			Evento e2 = new Evento("evento 2", LocalDate.now().plusDays(3), 120);
			Evento e3 = new Evento("evento 3", LocalDate.now().plusDays(3), 140);
			Evento e4 = new Evento("evento 4", LocalDate.now().plusDays(5), 160);
			
			pe.addEvento(e1);
			pe.addEvento(e2);
			pe.addEvento(e3);
			pe.addEvento(e4);
			
			System.out.println(pe.getEventiByDate(LocalDate.now().plusDays(3)));
			System.out.println("Event count: " + pe.getEventiCount());
			
//			pe.clearEventi();
//			System.out.println("Event count: " + pe.getEventiCount());
			
			System.out.println("Programma eventi: " + pe);
		} catch (Exception e) {
			
			System.out.println("Error: " + e.getMessage());
		}
	}
	public static void milestone3() {
		
		try {
			Concerto c = new Concerto("mio concerto", LocalDate.now().plusDays(3), 
					 100, LocalTime.parse("20:00"), BigDecimal.valueOf(23.99));
			
			System.out.println(c);

		} catch (Exception e) {
			
			System.out.println("Error: " + e.getMessage());
		}
	}
	public static void milestone2() {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Nome evento: ");
		String eventName = in.nextLine();
		
		System.out.print("Data evento: ");
		String eventDateStr = in.nextLine();
		LocalDate eventDate = LocalDate.parse(eventDateStr, Helper.IT_DATE_FORMATTER);
		
		System.out.print("Numero posti disponibili: ");
		String eventSeatCapacityStr = in.nextLine();
		int eventSeatCapacity = Integer.valueOf(eventSeatCapacityStr);
		
		try {
			
			Evento evento = new Evento(eventName, eventDate, eventSeatCapacity);
			System.out.println("Evento:\n" + evento + "\n" + evento.getSeatStr());
			
			System.out.print("Posti da prenotare: ");
			String eventSeatReservedStr = in.nextLine();
			int eventSeatReserved = Integer.valueOf(eventSeatReservedStr);
			
			evento.prenota(eventSeatReserved);
			System.out.println("Evento:\n" + evento + "\n" + evento.getSeatStr());
			
			System.out.print("Posti da disdire: ");
			String eventSeatReservedCancelStr = in.nextLine();
			int eventSeatReservedCancel = Integer.valueOf(eventSeatReservedCancelStr);
			
			evento.disdici(eventSeatReservedCancel);
			System.out.println("Evento:\n" + evento + "\n" + evento.getSeatStr());
		} catch (Exception e) {
			
			System.out.println("Erorr: " + e.getMessage());
		} finally {
			
			in.close();
		}
	}
	
	public static void test1() {
		
		try {
			
			Evento e = new Evento("Super-evento Java", LocalDate.now().plusDays(3), 20);
			System.out.println("Evento:\n" + e + "\n" + e.getSeatStr());
			
			e.prenota();
			System.out.println("Evento:\n" + e + "\n" + e.getSeatStr());
			
			e.prenota();
			System.out.println("Evento:\n" + e + "\n" + e.getSeatStr());
			
			e.prenota();			
			System.out.println("Evento:\n" + e + "\n" + e.getSeatStr());
			
			System.out.println("\n--------------------------------\n");
			
			e.disdici();
			System.out.println("Evento:\n" + e + "\n" + e.getSeatStr());
			
			e.disdici();
			System.out.println("Evento:\n" + e + "\n" + e.getSeatStr());
			
			e.disdici();
			System.out.println("Evento:\n" + e + "\n" + e.getSeatStr());
			
//			e.disdici();
//			System.out.println("Evento:\n" + e + "\n" + e.getSeatStr());
			
			System.out.println("\n--------------------------------\n");
			
		} catch (Exception e) {
			
			System.out.println("Erorr: " + e.getMessage());
		}
	}
}
