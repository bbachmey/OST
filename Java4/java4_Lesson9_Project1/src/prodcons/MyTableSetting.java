package prodcons;

import java.applet.Applet;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyTableSetting extends Applet implements ActionListener {
    Soup s;                                             // we will show the soup bowl with the soup's alphabet pieces

    Panel north;
    Panel center;
    GridLayout grid;
    Button buttonStop;
    Button buttonStart;
    
	Producer p1;    
	Consumer c1;   

    public void init(){
        setSize(400,200);                                 // make the applet size big enough for our soup bowl
        
        this.setLayout(new BorderLayout());
        north = new Panel();
        north.setBackground(Color.WHITE);
        
        center = new Panel();
        //center.setBackground(Color.BLACK);

        buttonStop = new Button("Stop");
		buttonStop.addActionListener(this);
        north.add(buttonStop);
        
        buttonStart = new Button("Start");
        buttonStart.addActionListener(this);
        north.add(buttonStart);

        this.add("North", north);
        //this.add("Center", center);
        s = new Soup();                                   // instantiate the Soup
        p1 = new Producer(this, s);              // declare and instantiate one producer thread - state of NEW
        c1 = new Consumer(this, s);              // declare and instantiate one consumer thread - state of NEW

        p1.start();                                       // start the producer thread
        c1.start();                                       // start the consumer thread
    }

    
    
    public void paint(Graphics g){                        // first we make the bowl and spoon
        int x;
        int y;

        int centerX = center.getX();
        int centerY = center.getY();
        int plusY = north.getY()+30;
        int plusX = 40;
        
        int bowlLength = 150;                               // bowl's dimensions as variables in case we want to change it
        int bowlWidth = 220;
        int bowlX = plusX+60;
        int bowlY = plusY+10;
        
        center.repaint();
        
        //center.paint(g)
        
//        System.out.println("Center X: " + center.getX());
//        System.out.println("Center Y: " + center.getY());

        g.setColor(Color.orange);
        g.fillOval(bowlX, bowlY, bowlWidth, bowlLength);  // the bowl
        g.setColor(Color.cyan);
        g.fillOval(plusX+10, plusY+25, 40, 55);               // the spoon
        g.fillOval(plusX+25, plusY+80, 8, 75);
        g.setColor(Color.black);                          // black outlines for the dinnerware
        g.drawOval(plusX+10, plusY+25, 40, 55);
        g.drawOval(plusX+25, plusY+80, 8, 75);
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



	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == buttonStop) {
			
			p1 = null;
			c1 = null;
		}
		else if (e.getSource() == buttonStart) {
			
	        p1 = new Producer(this, s);          
	        c1 = new Consumer(this, s);          

	        p1.start();                                   
	        c1.start();                                   
			
		}

		
	}	
}