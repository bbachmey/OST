package prodcons;

import java.applet.Applet;
//import java.util.*;            // don't need anymore because we have array copy
import java.awt.*;

public class MyTableSetting extends Applet {   
    Soup s;
    Producer p1;                // we need as Instance Variables so we can access outside of the init() 
    Consumer c1;
    int bowlLength = 150;
    int bowlWidth = 220;
    int bowlX = 60;
    int bowlY = 10;
    String justAte;

    public void init(){
        setSize(400,200);
        s = new Soup();
        p1 = new Producer(this, s);                                   // don't declare here again or it is only local
        System.out.println("Producer is in state " + p1.getState());  // show the state of the thread at this point
        c1 = new Consumer(this, s);

        p1.start();          
        c1.start(); 
        System.out.println("Consumer is in state " + c1.getState());   // show the state of the thread at this point    
    }

    public void paint(Graphics g){
        int x;
        int y;

        g.setColor(Color.yellow);
        g.fillOval(bowlX,bowlY, bowlWidth, bowlLength);
        g.setColor(Color.cyan);
        g.fillOval(10,25, 40, 55);
        g.fillOval(25,80, 8, 75);
        g.setColor(Color.black);
        g.drawOval(10,25, 40, 55);
        g.drawOval(25,80, 8, 75);
        g.drawOval(bowlX,bowlY, bowlWidth, bowlLength); 
        Font standardFont = getFont();                        // tell what just ate in spoon
        Font bigFont = new Font("Helvetica", Font.BOLD, 20);
        g.setFont(bigFont);
        if (justAte != null) {
            g.drawString(justAte, 25, 55);
            justAte = null;
        }
        else {
            g.setFont(standardFont);
            g.drawString("waiting", 13, 55);
            g.setFont(bigFont);
        }
        Object [] contents = s.getContents();  // bring back a fresh array of Object
        for(Object each : contents){           // no longer tied in memory to buffer in Soup
            x = bowlX + bowlWidth / 4 + (int)(Math.random() * (bowlWidth / 2));
            y = bowlY + bowlLength / 4 + (int)(Math.random() * (bowlLength / 2));
            g.drawString((String)each, x, y);                            // show the alphabet piece being eaten
        }
        System.out.println("Producer is in state " + p1.getState());   // show state of Producer (remember that we put it to sleep)
        System.out.println("Consumer is in state " + c1.getState());
        if(c1.getState()==Thread.State.TIMED_WAITING){                 // note access to enumerated types for Thread States
            checkState();                                               // get last repaint() in so see TERMINATED
        }
    }

    public void recentlyAte(String morsel){
        justAte = morsel;
    }	

    public void checkState(){
        try{Thread.sleep(1000);
        } catch(InterruptedException e) { }                           // Even the Applet has a Thread.  This command puts this (Applet's) Thread to sleep
        repaint();
    }
}