package org.java.landeria.pojo.command;

public class Command {

	private String name;
	private String description;
	private String parameterName;
	
	private boolean machineRequired;
	private boolean parameterRequired;
	
	public Command(String name, String description) {
		this(name, description, true);
	}
	public Command(String name, String description, boolean machineRequired) {
	
		setName(name);
		setDescription(description);
		setMachineRequired(machineRequired);
		setParameterRequired(false);
	}
	public Command(String name, String description, String parameterName) {
		
		setName(name);
		setDescription(description);
		setParameterName(parameterName);
		setMachineRequired(true);
		setParameterRequired(true);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getParameterName() {
		return parameterName;
	}
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
	public boolean isMachineRequired() {
		return machineRequired;
	}
	public void setMachineRequired(boolean machineRequired) {
		this.machineRequired = machineRequired;
	}
	public boolean isParameterRequired() {
		return parameterRequired;
	}
	public void setParameterRequired(boolean parameterRequired) {
		this.parameterRequired = parameterRequired;
	}
		
	@Override
	public String toString() {
		
		return getName() + (
					isMachineRequired() 
					? " <numero_macchina>"
					: ""
				) + (
					isParameterRequired()
					? " <" + getParameterName() + ">"
					: ""
				) + " | " + getDescription();
				
	}
}
