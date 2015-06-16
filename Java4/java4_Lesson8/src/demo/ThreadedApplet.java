package demo;

import java.awt.Graphics;
import java.applet.Applet;

public class ThreadedApplet extends Applet implements Runnable {

    Thread appletThread;
    String messages[] = {"Hello Thread World!" , "I'm doing fine." , "Good-bye for now!"};
    int i = 0;

    public void paint(Graphics g) {
	    g.drawString(messages[i], 15, 50);
    }

    public void run() {
        while (appletThread != null) {  // checks if Thread exists
            i = (i + 1) % messages.length;
            repaint();
            System.out.println("Hey! I'm still here");
            try { 
                appletThread.sleep(5000);   // sleep--put in Not Runnable State (TIMED_WAITING)
            } catch (InterruptedException e){ }
        }
    }

    public void start() {             // start of Applet
        if (appletThread == null) {
            appletThread = new Thread(this);  // new Thread()--achieve New Thread State
            appletThread.start();             // start of Thread--achieve Runnable State
        }
    }
    
    public void stop() {                      // stop Applet
        appletThread = null;                  // stop Thread by destroying--put in Dead State
    }
}