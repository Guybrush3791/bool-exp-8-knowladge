package org.java.train;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TicketInitTest {

	@Test
	public void goodInitTicketTest() throws Exception {
		
		assertDoesNotThrow(() -> new Ticket(10, 20));
	}
	@Test
	public void badKmInitTicketTest() throws Exception {
		
		assertThrows(Exception.class, () -> new Ticket(-10, 20));
	}
	@Test
	public void badAgeInitTicketTest() throws Exception {
		
		assertThrows(Exception.class, () -> new Ticket(10, -20));
	}
}
