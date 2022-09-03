package org.cusey;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainInterfaceClass {
	
	private static final Logger logger = LogManager.getLogger(MainInterfaceClass.class);

	public static void main(String[] args) {
	    logger.info("*** INTERFACE CLASS ***");

        //Pattern pattern = new Pattern(); // An interface class cannot be instantiated.

        Customers initial = new Customers("Tom","Smith");

        logger.info("--- Copy ---");
        Customers copy = initial.copy();

        logger.info("-- Before Copy (initial) " + initial.toString());
        logger.info("-- Before Copy (copy) " + copy.toString());

        copy.setFirst_name("Bill");
        copy.setLast_name("Jones");


        logger.info("-- After Copy (initial) " + initial.toString());
        logger.info("-- After Copy (copy)" + copy.toString());

        logger.info("--- Clone---");
        Customers clone = initial.clone();

        logger.info("-- Before Copy (initial) " + initial.toString());
        logger.info("-- Before Copy (clone) " + clone.toString());

        clone.setFirst_name("John");
        clone.setLast_name("Peterson");

        logger.info("-- After Copy (initial) " + initial.toString());
        logger.info("-- After Copy (clone)" + clone.toString());

	}

}
