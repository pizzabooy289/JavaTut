package org.cusey;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionPool {
	
	    private static final Logger logger = LogManager.getLogger(ConnectionPool.class);
	
		private Semaphore semaphore;
	    private int poolSize = 0;
	    private MyConnection[] myConn;

	    public ConnectionPool (int poolSize){

	        this.poolSize = poolSize;
	        this.myConn = new MyConnection[poolSize];
	        
	        for (int i = 0; i < poolSize; ++i){
	        	myConn[i] = new MyConnection();
	        }
	        
	        this.semaphore = new Semaphore (poolSize);

	    }
	    
	    
	    /**
	     Get a permit from our semaphore object.
	     Check for a available object, and return it if is found.
	     Otherwise, throw an exception (this should not happen
	     because the pool size is initialized in the constructor).
	     */
	    public MyConnection checkOutConnection ()
	    {
	        try
	        {
	            semaphore.acquire ();
	        }
	        catch (InterruptedException error)
	        {
	        	logger.info( error.getMessage() );
	        }

	        synchronized (this)
	        {
	            for (int i = 0; i < myConn.length; ++i)
	                if (!myConn[i].isInUse())
	                {
	                	myConn[i].setInUse(true);
	                	logger.info("checkOutConnection: " + myConn[i].toString() );
	                    return myConn[i];
	                }
	        }

	        throw new IllegalStateException ("No connections available.");
	    }
	    
	    public synchronized void checkInConnection (MyConnection connection)
	    {
	        for (int i = 0; i < myConn.length; ++i)
	            if (myConn[i].getIdNumber() == connection.getIdNumber())
	            {
	                if (!myConn[i].isInUse())
	                    throw new IllegalArgumentException("This connection has already been returned.");

	                myConn[i].setInUse(false);
                	logger.info("checkInConnection: " + myConn[i].toString() );
	                semaphore.release ();
	                return;
	            }

	        throw new IllegalArgumentException ("No such object in pool.");
	    }

		public MyConnection[] getMyConn() {return myConn;}
		public void setMyConn(MyConnection[] myConn) {this.myConn = myConn;}
		
		public int getPoolSize() {return poolSize;}
		public void setPoolSize(int poolSize) {this.poolSize = poolSize;}

		@Override
		public String toString() {
			return "\n ConnectionPool [myConn=" + Arrays.toString(myConn) + "]";
		}
	    
	    


}
