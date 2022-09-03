package org.cusey.ModifierTypes.Protected;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cusey.ModifierTypes.Default.Truck;

public class Van extends Truck{
	
	
	private static final Logger logger = LogManager.getLogger(Van.class);
	
    public void printTruckModel() {

    	logger.info( "Truck Name: " + model );
    }
}
