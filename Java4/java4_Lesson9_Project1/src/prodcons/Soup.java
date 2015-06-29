package prodcons;

import java.util.*;

public class Soup {
	
	// buffer holds what is in the soup
	private ArrayList <String> buffer = new ArrayList<String>();  

	// limit to 6 alphabet pieces
	private int capacity = 6;                                                 

	// synchronized makes others BLOCKED
	public synchronized String eat() {                                        
	
		// cannot eat if nothing is there, so check to see if it is empty
		while(buffer.isEmpty()){                                                                                               
			try {
				// if so, we WAIT until someone puts something there
				this.wait();                                                       
				// doing so temporarily allows other synchronized methods to run (specifically - add)
			} catch (InterruptedException e) {}                      
			// we will not get out of this while until something is there to eat
		}                                                                     
		// get a random alphabet in the soup
		String toReturn = buffer.get((int)(Math.random() * buffer.size()));        
		// remove it so no one else can eat it
		buffer.remove(toReturn);                                              
		// reduce the size of the buffer to fit how many pieces are there
		buffer.trimToSize();                                                  
		// tell anyone WAITing that we have eaten something and are done
		this.notifyAll();                                                          
		// actually return the alphabet piece to the consumer who asked to eat it
		return(toReturn);                                                     
	}

	// synchronized makes others BLOCKED
	public synchronized void add(String c) {                                  
		// cannot add more pieces if the buffer is full to capacity
		while (buffer.size() == capacity) {
			try {
				// if so, we WAIT - temporarily allows other synchronized methods to run - i.e., eat()

				this.wait();
				/*
					Causes the current thread to wait until another thread invokes the notify() 
					method or the notifyAll() method for this object. 
					
					In other words, this method behaves exactly as if it simply performs the call wait(0).

					The current thread must own this object's monitor. 
					
					The thread releases ownership of this monitor and waits until another thread notifies threads 
					waiting on this object's monitor to wake up either through a call to the 
					notify method or the notifyAll method. The thread then waits until it can 
					re-obtain ownership of the monitor and resumes execution. 
					
				 */
			} catch (InterruptedException e) {}
			// we will not get out of this while until something has been eaten to make room
		}                                                                     
		// add another alphabet piece to the soup
		buffer.add(c);
		// tell anyone WAITing that we have added something and are done
		this.notifyAll();
	}

	// we want to be able to get the contents so we can show them in the GUI view
	public ArrayList <String> getContents(){                            
		// multiple problems with this - we will address later
		return (buffer);
	}
}