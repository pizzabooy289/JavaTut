package org.cusey;

import java.util.UUID;

public class MyConnection {
	
	private boolean inUse;
	private UUID idNumber;

	public MyConnection() {
		this.inUse = false;
		
	    //generates random UUID    
		this.idNumber=UUID.randomUUID();   
	}

	public boolean isInUse() {return inUse;}
	public void setInUse(boolean inUse) {this.inUse = inUse;}

	public UUID getIdNumber() {return idNumber;}
	public void setIdNumber(UUID idNumber) {this.idNumber = idNumber;}

	@Override
	public String toString() {
		return " \n MyConnection [inUse=" + inUse + ", idNumber=" + idNumber + "]";
	}

}
