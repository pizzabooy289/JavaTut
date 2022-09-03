package org.cusey.ModifierTypes.Default;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Car extends Truck {
	
	private static final Logger logger = LogManager.getLogger(Car.class);

    public void printTruckName(){

    	logger.info( "Truck Name: " + name);
    }
}
