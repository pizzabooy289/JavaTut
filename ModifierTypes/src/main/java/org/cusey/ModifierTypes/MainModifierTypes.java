package org.cusey.ModifierTypes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cusey.ModifierTypes.Default.Car;
import org.cusey.ModifierTypes.Protected.Van;

public class MainModifierTypes {
	
	private static final Logger logger = LogManager.getLogger(MainModifierTypes.class);

    public static void main(String[] args) {


    	logger.info("*** MODIFIER TYPES ***");

    	logger.info("--- Java Access Modifiers (Default) ---");

        Car car = new Car();
        car.printTruckName();

        logger.info("--- Java Access Modifiers (Protected) ---");

        Van van = new Van();
        van.printTruckModel();



    }

}
