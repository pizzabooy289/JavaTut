package org.cusey;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class MainThread<E> {
	
	private static final Logger logger = LogManager.getLogger(MainThread.class);
	
    public List<E> list = new ArrayList<E>();

    public boolean outIfAbsent(E x, String threadName){
        synchronized(list){
        	
        	logger.info("Thread Name: " + threadName );
        	logger.info("Item add to the list: " + x);

            boolean absent = !list.contains(x);
            if(absent){
            	logger.info("Element " + x + " does not exist in list so added it to the list.");
                list.add(x);
            }
            logger.info("\n");
            return absent;
        }

    }

	public static void main(String[] args) {
		
		    logger.info(" *** START *** ");
		
	        final MainThread<String> thread = new MainThread<>();

	        Thread threadOne  = new Thread( new Runnable(){
	            @Override
	            public void run() {thread.outIfAbsent("JOHN", "Thread One");}
	        });

	        Thread threadTwo = new Thread( new Runnable(){
	            @Override
	            public void run() {thread.outIfAbsent("JOHN", "Thread Two");}
	        });

	        Thread threadThree = new Thread( new Runnable(){
	            @Override
	            public void run() {thread.outIfAbsent("JOHN", "Thread Three");}
	        });

	        Thread threadFour = new Thread( new Runnable(){
	            @Override
	            public void run() {thread.outIfAbsent("TOM", "Thread Four");}
	        });

	        Thread threadFive = new Thread( new Runnable(){
	            @Override
	            public void run() {thread.outIfAbsent("TOM", "Thread Five");}
	        });

	        threadOne.start();
	        threadTwo.start();
	        threadThree.start();
	        threadFour.start();
	        threadFive.start();
	        
	        logger.info(" *** END *** ");

	}

}
