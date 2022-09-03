package org.cusey;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainConcurrency {
	
	private static final Logger logger = LogManager.getLogger(MainConcurrency.class);
	
	private static final int POOL_SIZE = 3;

	public static void main(String[] args) {
		
		
		logger.info(" *** START *** ");

		ConnectionPool  pool = new ConnectionPool(POOL_SIZE);
		MyConnection[] myConnArray = pool.getMyConn();
		
		logger.info( "Connection Pool: " + myConnArray.toString() );
		
		logger.info(pool.toString());
		
		logger.info("\n");
		
        Thread threadOut1  = new Thread( new Runnable(){
        	
            @Override
            public void run() {
            	MyConnection  conn = pool.checkOutConnection();
            	pool.checkInConnection(conn);
            	
            }
        });
        
        Thread threadOut2  = new Thread( new Runnable(){
        	
            @Override
            public void run() {
            	MyConnection  conn = pool.checkOutConnection();
            	pool.checkInConnection(conn);
            	
            }
        });

        
        threadOut1.start();
        threadOut2.start();

        
        logger.info(" *** END *** ");

	}

}
