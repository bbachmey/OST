import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ThreadsApplet extends Applet implements ActionListener {


	Button buttonOne; 
	Button buttonTwo; 
	Button buttonThree;

	TextArea textAreaOne; 
	TextArea textAreaTwo; 
	TextArea textAreaThree;

	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public void init() {		
		System.out.println("init");

		this.setSize(1200,400);

		Panel p1 = new Panel();
		Panel p2 = new Panel();

		Font buttonFont = new Font("Arial",Font.BOLD,24);
		Font textFont = new Font("Courier",Font.PLAIN,12);

		setLayout(new BorderLayout());
		setBackground(Color.red);
		setForeground(Color.white);

		p1.setBackground(Color.lightGray);
		p1.setLayout(new GridLayout(1,3));
		p2.setLayout(new GridLayout(1,3));

		add("North", p1);

		add("Center", p2);

		buttonOne = new Button("One");
		buttonOne.addActionListener(this);
		buttonOne.setForeground(Color.BLACK);
		buttonOne.setFont(buttonFont);
		p1.add(buttonOne);

		buttonTwo = new Button("Two");
		buttonTwo.addActionListener(this);
		buttonTwo.setForeground(Color.BLACK);
		buttonTwo.setFont(buttonFont);
		p1.add(buttonTwo);

		buttonThree = new Button("Three");
		buttonThree.addActionListener(this);
		buttonThree.setForeground(Color.BLACK);
		buttonThree.setFont(buttonFont);
		p1.add(buttonThree);

		textAreaOne = new TextArea(10,30);
		textAreaOne.setEditable(false);
		textAreaOne.setBackground(Color.BLACK);
		textAreaOne.setForeground(Color.WHITE);
		textAreaOne.setFont(textFont);
		p2.add(textAreaOne);

		textAreaTwo = new TextArea(10,30);
		textAreaTwo.setEditable(false);
		textAreaTwo.setBackground(Color.BLACK);
		textAreaTwo.setForeground(Color.WHITE);
		textAreaTwo.setFont(textFont);
		p2.add(textAreaTwo);

		textAreaThree = new TextArea(10,30);
		textAreaThree.setEditable(false);
		textAreaThree.setBackground(Color.BLACK);
		textAreaThree.setForeground(Color.WHITE);
		textAreaThree.setFont(textFont);
		p2.add(textAreaThree);

	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		super.start();
		System.out.println("start");

	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		System.out.println("paint");

		g.drawString("My number matches", 10,20);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.toString());

		if (e.getSource() == buttonOne) {
			System.out.println("One button pushed");
			AppletThread one = new AppletThread();
			one.start(textAreaOne, buttonOne);
		}
		else if (e.getSource() == buttonTwo) {
			System.out.println("Two button pushed");
			AppletThread two = new AppletThread();
			two.start(textAreaTwo, buttonTwo);
		}
		else if (e.getSource() == buttonThree) {
			System.out.println("Three button pushed");
			AppletThread three = new AppletThread();
			three.start(textAreaThree, buttonThree);
		}

	}

	class AppletThread extends Thread {

		TextArea textArea;
		Button button;
		String message;
		Date sleep;
		Date wake;
		int miliseconds = 3000;
		
		public void run() {

			textArea.setText(message);
			sleep = new Date();
			textArea.append("\n The time is " + dateFormat.format(sleep) );
			
			for(int i=0;i<4;i++){

				try {
					textArea.append("\n I am going to sleep now");
					textArea.append("\n");
					miliseconds = (int) (Math.random() * 5000);
					sleep = new Date();
					sleep(miliseconds);
					wake = new Date();
					textArea.append("\n I am thread " + button.getLabel().toString());
					textArea.append("\n I am awake.");
					textArea.append("\n The time is " + dateFormat.format(wake) );		
					textArea.append("\n I was put to sleep for " + miliseconds + " miliseconds.");
					textArea.append("\n I have actually been asleep for " + (wake.getTime() - sleep.getTime()) + " miliseconds.");
						   
				}
				catch (InterruptedException e){
					System.out.println("Thread interrupted");
				}
			}

		}

		public void start(TextArea textArea, Button button) {
			this.textArea = textArea;
			this.button = button;
			this.message = " I am thread " + button.getLabel().toString();		
			this.start();
		}  
		
	}
}
