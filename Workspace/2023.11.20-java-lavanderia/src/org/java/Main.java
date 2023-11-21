package org.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.java.landeria.pojo.DryerMachine;
import org.java.landeria.pojo.WashingMachine;
import org.java.landeria.pojo.abs.Machine;
import org.java.landeria.pojo.command.Command;

public class Main {
	
	private static final Command EXIT_COMMAND = new Command("esci", "termina il programma", false);
	private static final Command[] COMMANDS = {
			new Command("apri", "apre lo sportello della macchina"),
			new Command("chiudi", "chiude lo sportello della macchina"),
			new Command("gettoni", "inserisce il numero di gettoni nella macchina specificata", "numero_gettoni"),
			new Command("lista", "fornisce la lista dei programmi"),
			new Command("programma", "seleziona il programma specificato sulla macchina indicata", "numero_programma"),
			new Command("avvia", "avvia il lavaggio o l’asciugatura sulla macchina specificata"),
			new Command("ferma", "ferma il lavaggio o l’asciugatura sulla macchina specificata"),
			new Command("detersivo", "ricarica il detersivo sulla macchina specificata", "quantita'"),
			new Command("ammorbidente", "ricarica l'ammorbidente sulla macchina specificata", "quantita'"),
	};

	private static List<Machine> machines;
	private static boolean goOn = true;
	
	public static void main(String[] args) {
		
//		Machine wm = new WashingMachine(false, 3, 882, 340);
//		Machine dm =  new DryerMachine(true, 10);
//		
//		System.out.println("Washing machine:\n" + wm + "\n" + wm.getProgramsStr());
//		System.out.println("Dryer machine:\n" + dm + "\n" + dm.getProgramsStr());
		
		machines = new ArrayList<>();
		
		Random rnd = new Random();
		for (int x=0;x<3;x++) {
			
			machines.add(new WashingMachine(
				rnd.nextBoolean(), 
				rnd.nextInt(0, 10),
				rnd.nextInt(0, 1000),
				rnd.nextInt(0, 500)
			));
		}
		for (int x=0;x<2;x++) {
			
			machines.add(new DryerMachine(
				rnd.nextBoolean(), 
				rnd.nextInt(0, 10)
			));
		}
		
		for (Machine m : machines) {
			
			System.out.println(m.getClass().getSimpleName().toUpperCase() + ":");
			System.out.println(m);
			System.out.println(m.getProgramsStr());
		}
		
		System.out.println("\n---------------------------------\n");
		printCommands();
		
		while (goOn) {
			
			try {
			execCommand();
			} catch (Exception e) { 
				System.out.println("Comando errato");
			}
		}
		
		System.out.println("\n---------------------------------\n");		
		System.out.println("The end");
	}
	
	private static void execCommand() {
		
		Scanner in = new Scanner(System.in);
		
		String strCommand = in.nextLine();
		if (strCommand.equals(EXIT_COMMAND.getName())) {
			goOn = false;
			return;
		}
		
		final String commandName = strCommand.split(" ")[0];
		boolean result = false;
		for (Command c : COMMANDS) {
			
			if (c.getName().equals(commandName)) {
				
				final String strMachineNumber = strCommand.split(" ")[1];
				final int machineNumber = Integer.valueOf(strMachineNumber);
				
				final Machine machine = machines.get(machineNumber);
				
				if (c.isParameterRequired()) {
					
					final String strParameterValue = strCommand.split(" ")[2];
					final int parameterValue = Integer.valueOf(strParameterValue);
					
					result = machine.execCommand(c, parameterValue);
				} else {
					
					result = machine.execCommand(c);
				}
			}
		}
		
		if (!result) System.out.println("Comando errato");
	}
	private static void printCommands() {
		
		for (Command c : COMMANDS) 
			System.out.println(c);
		
		System.out.println(EXIT_COMMAND + "\n");
	}
}
