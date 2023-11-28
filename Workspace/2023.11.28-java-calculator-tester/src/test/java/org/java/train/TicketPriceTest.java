package org.java.train;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TicketPriceTest {

	@Test
	public void normalAgePriceCalcTest() throws Exception {
		
		int km = 10;
		int age = 20;
		
		Ticket t = new Ticket(km, age);
		
		float price = km * .21f;
		
		assertEquals(price, t.getFinalPrice());
	}
	@Test
	public void minorAgePriceCalcTest() throws Exception {
		
		int km = 10;
		int age = 15;
		
		Ticket t = new Ticket(km, age);
		
		float price = (km * .21f) / 100 * 80;
		
		assertEquals(price, t.getFinalPrice());
	}
	@Test
	public void majorAgePriceCalcTest() throws Exception {
		
		int km = 10;
		int age = 75;
		
		Ticket t = new Ticket(km, age);
		
		float price = (km * .21f) / 100 * 60;
		
		assertEquals(price, t.getFinalPrice());
	}
}
