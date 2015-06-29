package prodcons;

import java.util.*;

class Soup {
    private ArrayList <String> buffer = new ArrayList<String>();;
    private int capacity = 6;

    public synchronized String eat() {
        while(buffer.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        String toReturn = buffer.get((int)(Math.random() * buffer.size()));
        buffer.remove(toReturn);
        buffer.trimToSize();
        notifyAll();
        return(toReturn);
    }

    public synchronized void add(String c) {
        while (buffer.size() == capacity) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        buffer.add(c);
        notifyAll();
    }

    public synchronized Object [] getContents(){  // see ArrayList about ConcurrentModificationException.
        Object [] temp = buffer.toArray();        // check out the API for ArrayList to see this toArray() method
        return (temp);                            // Make a clean copy so contents do not change when getting and/or displaying it
    } 
}