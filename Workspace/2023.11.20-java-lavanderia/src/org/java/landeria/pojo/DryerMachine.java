package org.java.landeria.pojo;

import java.util.Arrays;
import java.util.List;

import org.java.landeria.pojo.abs.Machine;
import org.java.landeria.pojo.program.Program;
import org.java.landeria.pojo.program.ProgramWDetergents;

public class DryerMachine extends Machine {

	private static final List<Program> PROGRAMS = Arrays.asList(new Program[] {
			new Program(1, "Rapido", 20, 2),
			new Program(2, "Intenso", 60, 4),
	});
	
	public DryerMachine(boolean openWindow, int coin) {
		super(openWindow, coin);
	}

	@Override
	public List<Program> getPrograms() {
		
		return PROGRAMS;
	}
	@Override
	public String[] getHeaders() {
		
		return Program.getProgramsHeader();
	}

	@Override
	public void startSelectedProgram() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopRunningProgram() {
		// TODO Auto-generated method stub
		
	}

}
