package demo;

import java.applet.Applet;
import java.awt.Graphics;

public class ThreadedApplet extends Applet implements Runnable {

    Thread appletThread;      // the thread we make will be an instance of the class Thread
    String messages[] = {"Hello Thread World!" , "I'm doing fine." , "Goodbye for now!"};
    int i = 0;

    public void paint(Graphics g) {
	    g.drawString(messages[i], 15, 50);
    }

    public void run() {
        while (true){
	        i = (i+1)  % messages.length;
	        repaint();
	        try {
		        appletThread.sleep(5000);
	        } catch (InterruptedException e){}
	    }
    }

    public void start() {
        appletThread = new Thread(this);
        appletThread.start();
    }   
    
}