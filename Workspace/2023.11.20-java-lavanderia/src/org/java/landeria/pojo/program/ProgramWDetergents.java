package org.java.landeria.pojo.program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProgramWDetergents extends Program {

	private static final String[] PROGRAMS_HEADER = { 
	    "Consumo ammorbidente (ml)",
	    "Consumo detersivo (ml)",
	};
	
	private final int consDetergent;
	private final int consSoftener;
	
	public ProgramWDetergents(int number, String name, int duration, int coin, 
							  int consDetergent, int consSoftener) {
		super(number, name, duration, coin);
		 
		this.consDetergent = consDetergent;
		this.consSoftener = consSoftener;
	}
	
	public int getConsDetergent() {
		return consDetergent;
	}
	public int getConsSoftener() {
		return consSoftener;
	}
	
	public static String[] getProgramsHeader() {
		
		List<String> programs = new ArrayList<>(Arrays.asList(Program.getProgramsHeader()));
		programs.addAll(Arrays.asList(PROGRAMS_HEADER));
		
		return programs.toArray(new String[0]);
	}

	@Override
	public String[] getTableString() {
		
		List<String> values = new ArrayList<>(Arrays.asList(super.getTableString()));
		values.add(getConsDetergent() + "");
		values.add(getConsSoftener() + "");
		
		return values.toArray(new String[0]);
	}
	
	@Override
	public String toString() {
		
		return getName();
	}
}
