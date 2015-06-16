package prodcons;

import java.applet.Applet;
import java.util.*;
import java.awt.*;

public class MyTableSetting extends Applet {
    Soup s;                                             // we will show the soup bowl with the soup's alphabet pieces
    int bowlLength = 150;                               // bowl's dimensions as variables in case we want to change it
    int bowlWidth = 220;
    int bowlX = 60;
    int bowlY = 10;

    public void init(){
        setSize(400,200);                                 // make the applet size big enough for our soup bowl
        s = new Soup();                                   // instantiate the Soup
        Producer p1 = new Producer(this, s);              // declare and instantiate one producer thread - state of NEW
        Consumer c1 = new Consumer(this, s);              // declare and instantiate one consumer thread - state of NEW

        p1.start();                                       // start the producer thread
        c1.start();                                       // start the consumer thread
    }

    public void paint(Graphics g){                        // first we make the bowl and spoon
        int x;
        int y;
        g.setColor(Color.orange);
        g.fillOval(bowlX, bowlY, bowlWidth, bowlLength);  // the bowl
        g.setColor(Color.cyan);
        g.fillOval(10, 25, 40, 55);                       // the spoon
        g.fillOval(25, 80, 8, 75);
        g.setColor(Color.black);                          // black outlines for the dinnerware
        g.drawOval(10, 25, 40, 55);
        g.drawOval(25, 80, 8, 75);
        g.drawOval(bowlX,bowlY, bowlWidth, bowlLength);
        ArrayList <String> contents = s.getContents();  // get contents of the soup
        for (String each: contents){                      // individually add each alphabet piece in the soup
            x = bowlX + bowlWidth/4 +(int)(Math.random()* (bowlWidth/2));  // put them at random places to mimic stirring
            y = bowlY + bowlLength/4 + (int)(Math.random()* (bowlLength/2));
            Font bigFont = new Font("Helvetica", Font.BOLD, 20);
            g.setFont(bigFont);
            g.drawString(each, x, y);
        }
    }	
}