package org.java.helper;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

public class Helper {

	public static final DateTimeFormatter IT_DATE_FORMATTER = 
			DateTimeFormatter.ofPattern("d/MM/uuuu");
	public static final DateTimeFormatter IT_TIME_FORMATTER = 
			DateTimeFormatter.ofPattern("HH:mm");
	
	public static final DecimalFormat PRICE_FORMATTER = 
			new DecimalFormat("#,###.00 €");
}
