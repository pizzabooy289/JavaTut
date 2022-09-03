package org.cusey;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ConnectionPoolTest {
	
	private static final Logger logger = LogManager.getLogger(ConnectionPoolTest.class);
	
	private static final int POOL_SIZE = 3;
	private ConnectionPool pool = null;
	MyConnection[]  conn = null;
	
	
    @BeforeEach
    public void init() {
		pool = new ConnectionPool(POOL_SIZE);
		
		conn = pool.getMyConn();
		
		logger.info(pool.toString());

    }
	
   
    @Test
    @DisplayName("Assignment Test for the MyConnection Class")
    public void assignmentTest() {
		logger.info(" *** START *** ");
		
		assertNotNull( pool );
		assertNotNull( conn );
		
		if( pool != null  && conn != null) {
			for(int i = 0; i <conn.length; i++) {
				
				assertNotNull( conn[i] );
				
				if( conn[i] != null ) {
					assertFalse( conn[i].isInUse() );
					
					assertTrue( conn[i].getIdNumber().toString().length() == 36 );
				}

			}
		}
		


		
		logger.info(" *** END *** ");
    }
    
    
    @Test
    @DisplayName("Check OUT Connection Test")
    public void checkOutConnectionTest() {
    	
		logger.info(" *** START *** ");
		
		assertNotNull( pool );
		
		if( pool != null ) {
			
			MyConnection newConn = pool.checkOutConnection();
			
			assertTrue( newConn.isInUse() );
			
			logger.info( "New check out connection: " + newConn.toString() );
			
		}
		

		logger.info(" *** END *** ");
    }
    
    @Test
    @DisplayName("Check IN Connection Test")
    public void checkInConnectionTest() {
    	
		logger.info(" *** START *** ");
		
		assertNotNull( pool );
		
		if( pool != null ) {
			
			MyConnection newConn = pool.checkOutConnection();
			
			assertTrue( newConn.isInUse() );
			
			logger.info( "New check out connection: " + newConn.toString() );
			
			pool.checkInConnection(newConn);
			
			assertFalse( newConn.isInUse() );
			
			logger.info( "Check back into the pool: " + newConn.toString() );
			
		}
		

		logger.info(" *** END *** ");
    	
    }

}
