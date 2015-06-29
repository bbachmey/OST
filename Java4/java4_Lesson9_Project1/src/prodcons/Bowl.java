package prodcons;

import java.applet.Applet;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Bowl extends Applet implements ActionListener {

	// we will show the soup bowl with the soup's alphabet pieces
	Soup soup;                                             

	Panel north;
	Panel center;

	Button buttonStop;
	Button buttonStart;

	Producer producer;    
	Consumer consumer;   

	public void init(){

		// make the applet size big enough for our soup bowl
		setSize(400,200);                                 

		this.setLayout(new BorderLayout());

		north = new Panel();
		north.setBackground(Color.WHITE);

		buttonStop = new Button("Stop");
		buttonStop.addActionListener(this);
		north.add(buttonStop);

		buttonStart = new Button("Start");
		buttonStart.addActionListener(this);
		north.add(buttonStart);

		this.add("North", north);

		soup = new Soup();                                   // instantiate the Soup
		//        p1 = new Producer(this, s);              // declare and instantiate one producer thread - state of NEW
		//        c1 = new Consumer(this, s);              // declare and instantiate one consumer thread - state of NEW
		//
		//        p1.start();                                       // start the producer thread
		//        c1.start();                                       // start the consumer thread
	}

	public void paint(Graphics g){                        // first we make the bowl and spoon
		int x;
		int y;

		int plusY = north.getY()+30;
		int plusX = 40;

		int bowlLength = 150;                               // bowl's dimensions as variables in case we want to change it
		int bowlWidth = 220;
		int bowlX = plusX+60;
		int bowlY = plusY+10;

		g.setColor(Color.orange);
		g.fillOval(bowlX, bowlY, bowlWidth, bowlLength);  // the bowl
		g.setColor(Color.cyan);
		g.fillOval(plusX+10, plusY+25, 40, 55);               // the spoon
		g.fillOval(plusX+25, plusY+80, 8, 75);
		g.setColor(Color.black);                          // black outlines for the dinnerware
		g.drawOval(plusX+10, plusY+25, 40, 55);
		g.drawOval(plusX+25, plusY+80, 8, 75);
		g.drawOval(bowlX,bowlY, bowlWidth, bowlLength);
		ArrayList <String> contents = soup.getContents();  // get contents of the soup
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
			System.out.println("I said stop.");
			producer = null;
			consumer = null;
		}
		else if (e.getSource() == buttonStart) {

			System.out.println("I said start.");
			producer = new Producer(this, soup);          
			consumer = new Consumer(this, soup);          

			producer.start();                                   
			consumer.start();                                   

		}
	}	
}
