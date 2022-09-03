package org.cusey;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainSerialization {
	
	private static final Logger logger = LogManager.getLogger(MainSerialization.class);

	public static void main(String[] args) {
		
		
		logger.info("*** SERIALIZATION ***");

        String filename = "person.txt";
        PersonDetails person1 = new PersonDetails("hemanth", 10, "Male");
        PersonDetails person2 = new PersonDetails("bob", 12, "Male");
        PersonDetails person3 = new PersonDetails("Richa", 10, "Female");

        List<PersonDetails> outlist = new ArrayList<PersonDetails>();

        outlist.add(person1);
        outlist.add(person2);
        outlist.add(person3);

        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(outlist);
            out.close();
            logger.info("Object Persisted");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        logger.info("*** Deserialization ***");
        try
        {   
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
              
            // Method for deserialization of object
            List<PersonDetails> inlist = (List<PersonDetails>)in.readObject();
              
            in.close();
            file.close();
            
            // Getting ListIterator
            ListIterator<PersonDetails> inIterator= inlist.listIterator();
     
            // Traversing elements using next() method
            while (inIterator.hasNext()) {
            	
            	PersonDetails personDetails = inIterator.next();
            	
            	logger.info( personDetails.toString() );
            }
              
        }
          
        catch(IOException ex)
        {
        	logger.info("IOException is caught");
        }
        
        catch(ClassNotFoundException ex)
        {
        	logger.info("ClassNotFoundException is caught");
        }

    }

}

