package org.java.landeria.pojo.abs;

import java.util.ArrayList;
import java.util.List;

import org.java.landeria.pojo.command.Command;
import org.java.landeria.pojo.program.Program;

import com.bethecoder.ascii_table.ASCIITable;

public abstract class Machine {

	private boolean openWindow;
	private int coins;
	
	private int selectedProgram = -1; 
	
	public Machine(boolean openWindow, int coin) {
		
		setOpenWindow(openWindow);
		setCoins(coin);
	}
	
	public boolean execCommand(Command command) {
		
		return execCommand(command, null);
	}
	public boolean execCommand(Command command, Integer parameter) {
		
		switch(command.getName()) {
		
			case "apri": setOpenWindow(true); break;
			case "chiudi": setOpenWindow(false); break;
			case "gettoni": addCoin(parameter); break;
			case "lista": printProgramStr(); break;
			case "avvia": System.out.println("work in progress"); break;
			case "ferma": System.out.println("work in progress"); break;
			
			default: return false;
		}
		
		System.out.println(this);
		
		return true;
	}
	public void printProgramStr() {
		
		System.out.println(getProgramsStr());
	}
	public String getProgramsStr() {
		
		/**
//		 * String[] --> { "valore1", "valore2", "valore3", ... }
//		 * String[][] values = {
//		 * 0	{ "valore1", "valore2", "valore3", ... },
//		 * 1	{ "valore4", "valore5", "valore6", ... },
//		 * 			0			1			2
//		 * 		...
//		 * };
//		 * String[] element = values[0]; // --> { "valore1", "valore2", "valore3", ... }
//		 * String subElem = values[1][2]; // --> "valore1"
//		 */
		
		List<String[]> listData = new ArrayList<>();
		for (Program pwd : getPrograms()) {
			listData.add(pwd.getTableString());
		}

		String[][] data = listData.toArray(new String[0][]);
	    return ASCIITable.getInstance().getTable(getHeaders(), data);
	}
	public abstract List<Program> getPrograms();
	public abstract String[] getHeaders();
	
	public void selectProgram(int programIndex) {
		
		setSelectedProgram(programIndex);
	}
	public abstract void startSelectedProgram();
	public abstract void stopRunningProgram();
	
	public boolean isOpenWindow() {
		return openWindow;
	}
	public void setOpenWindow(boolean openWindow) {
		this.openWindow = openWindow;
	}
	public void toggleOpenWindow() {
		
		setOpenWindow(!isOpenWindow());
	}
	public int getCoins() {
		return coins;
	}
	public void setCoins(int coins) {
		this.coins = coins;
	}
	public void addCoin(int coins) {
		
		setCoins(getCoins() + coins);
	}	
	
	public int getSelectedProgram() {
		return selectedProgram;
	}
	public void setSelectedProgram(int selectedProgram) {
		
//		if (selectedProgram < 1 || selectedProgram >= getPrograms().length())
//			throw new Exception("...");
		
		this.selectedProgram = selectedProgram;
	}
	public boolean isSelectedProgram() {
		
		return getSelectedProgram() > 0;
	}

	@Override
	public String toString() {
		
		return "window: " + (isOpenWindow() ? "open" : "close") + "\n"
				+ "coin: " + getCoins() + "\n"
				+ "selected program: " + (
						isSelectedProgram() 
						? getSelectedProgram() 
						: "none"
					);
	}
}
