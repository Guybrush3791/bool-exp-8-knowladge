package org.java.landeria.pojo.program;

public class Program {

	private static final String[] PROGRAMS_HEADER = { 
	    "Numero",
	    "Nome",
	    "Durata (minuti)",
	    "Gettoni",
	};
	
	private final int number;
	private final String name;
	private final int duration;
	private final int coin;
	
	public Program(int number, String name, int duration, int coin) {
		
		this.number = number;
		this.name = name;
		this.duration = duration;
		this.coin = coin;
	}
	
	public int getNumber() {
		return number;
	}
	public String getName() {
		return name;
	}
	public int getDuration() {
		return duration;
	}
	public int getCoin() {
		return coin;
	}
	
	public static String[] getProgramsHeader() {
		return PROGRAMS_HEADER;
	}

	public String[] getTableString() {
		
		return new String[] {
			getNumber() + "",	
			getName(),
			getDuration() + "",
			getCoin() + ""
		};
	}
}
