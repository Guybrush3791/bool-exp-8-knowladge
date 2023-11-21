package org.java.landeria.pojo;

import java.util.Arrays;
import java.util.List;

import javax.print.attribute.HashPrintJobAttributeSet;

import org.java.landeria.pojo.Tank.TankTypology;
import org.java.landeria.pojo.abs.Machine;
import org.java.landeria.pojo.command.Command;
import org.java.landeria.pojo.program.Program;
import org.java.landeria.pojo.program.ProgramWDetergents;

public class WashingMachine extends Machine {

	private static final List<Program> PROGRAMS = Arrays.asList(new ProgramWDetergents[] {
			new ProgramWDetergents(1, "Rinfrescante", 20, 5, 20, 25),
			new ProgramWDetergents(2, "Rinnovante", 40, 10, 40, 50),
			new ProgramWDetergents(3, "Sgrassante", 60, 15, 60, 100),
	});
	
	private Tank detergent;
	private Tank softener;
	
	public WashingMachine(boolean openWindow, int coin, int detergent, int softener) {
		super(openWindow, coin);
		
		setDetergent(new Tank(TankTypology.DETERGENT, detergent));
		setSoftener(new Tank(TankTypology.SOFTENER, softener));
	}

	public Tank getDetergent() {
		return detergent;
	}
	public void setDetergent(Tank detergent) {
		this.detergent = detergent;
	}
	public void addDetergent(int detergent) {
		
		getDetergent().addLevel(detergent);
	}

	public Tank getSoftener() {
		return softener;
	}
	public void setSoftener(Tank softener) {
		this.softener = softener;
	}
	public void addSoftener(int softener) {
		
		getSoftener().addLevel(softener);
	}

	@Override
	public boolean execCommand(Command command, Integer parameter) {
		
		if (super.execCommand(command, parameter)) return true;
		
		switch(command.getName()) {
		
			case "detersivo": addDetergent(parameter); break;
			case "ammorbidente": addSoftener(parameter); break;
			
			default: return false;
		}
		
		System.out.println(this);
		
		return true;
	}
	
	@Override
	public List<Program> getPrograms() {
		
		return PROGRAMS;
	}
	@Override
	public String[] getHeaders() {
		
		return ProgramWDetergents.getProgramsHeader();
	}
	
	@Override
	public void startSelectedProgram() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void stopRunningProgram() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		
		return super.toString() + "\n"
				+ "detergent: " + getDetergent() + "\n"
				+ "softener: " + getSoftener();
	}
}
