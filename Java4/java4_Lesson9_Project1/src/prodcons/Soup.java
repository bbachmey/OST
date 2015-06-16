package prodcons;

import java.util.*;

public class Soup {
    private ArrayList <String> buffer = new ArrayList<String>();  // buffer holds what is in the soup
    private int capacity = 6;                                                 // limit to 6 alphabet pieces

    public synchronized String eat() {                                        // synchronized makes others BLOCKED
        while(buffer.isEmpty()){                                              // cannot eat if nothing is there, so check to see if it is empty                                                 
            try {
                wait();                                                       // if so, we WAIT until someone puts something there
            } catch (InterruptedException e) {}                               // doing so temporarily allows other synchronized methods to run (specifically - add)
        }                                                                     // we will not get out of this while until something is there to eat
        String toReturn = buffer.get((int)(Math.random() * buffer.size()));   // get a random alphabet in the soup     
        buffer.remove(toReturn);                                              // remove it so no one else can eat it
        buffer.trimToSize();                                                  // reduce the size of the buffer to fit how many pieces are there
        notifyAll();                                                          // tell anyone WAITing that we have eaten something and are done
        return(toReturn);                                                     // actually return the alphabet piece to the consumer who asked to eat it
    }

    public synchronized void add(String c) {                                  // synchronized makes others BLOCKED
        while (buffer.size() == capacity) {                                   // cannot add more pieces if the buffer is full to capacity
            try {
                wait();                                                       // if so, we WAIT - temporarily allows other synchronized methods to run - i.e., eat()
            } catch (InterruptedException e) {}
        }                                                                     // we will not get out of this while until something has been eaten to make room
        buffer.add(c);                                                        // add another alphabet piece to the soup 
        notifyAll();                                                          // tell anyone WAITing that we have added something and are done
    }

    public ArrayList <String> getContents(){                            // we want to be able to get the contents so we can show them in the GUI view
        return (buffer);                                                      // multiple problems with this - we will address later
    }
}