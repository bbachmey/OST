/**
 * 
 */

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * @author bbachmey
 * @instructions  
 * Edit the FrameTest class you submitted for Lesson 2. 
 * This time the application should declare 16 variables (two for each primitive data type) 
 *   using proper syntax and naming conventions. 
 * Make them have appropriate values to illustrate the limits of their type. 
 * Then, use the System class to print out the names, types, and respective values for one 
 *   of each primitive data type and the Frame displayed to print out the names, types, and 
 *   respective values for the other 8 (also one of each). 
 * Specifically, one of each primitive data type will be seen in the console, and one of each 
 *   will be seen in the Frame. 
 * If you edited this in java2_Lesson2, hand in that project with the edited class. 
 * Otherwise hand in the project where you have put the code.
 */
public class FrameTest extends Frame {

	//declare 16 primitive data types as instance variables
	byte one;
	byte two;
	short three;
	short four;
	int five;
	int six;
	long seven;
	long eight;
	float nine;
	float ten;
	double eleven;
	double twelve;
	char thirteen;
	char fourteen;
	boolean fifteen;
	boolean sixteen;
	
	/**
	 * @param args
	 * main() is the first method called when the application is started
	 */
	public static void main(String[] args) {
		//declare an instance of the FrameTest class
		FrameTest ft;
		//instantiate the FrameTest object
		//sending a String value sets the Title displayed in the window
		ft = new FrameTest("Java 2 - Project 3");
		//call a custom method to "start" the application
		ft.go();

	}
	
	/**
	 * default constructor for FrameTest class 
	 */
	public FrameTest(String title) {
		//call the constructor of the superclass Frame
		super(title);
	}
	
	/**
	 * This method is called from main(String[] args)
	 */
	public void go() {
		//send a message to the console
		System.out.println("The go() method has been called.");
		//set the size of the window
		setSize (500, 300);
		//make the window visible
		setVisible(true);
		//add a mouse listener to close the application
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				setVisible(false);
				dispose();
				//Quit the app.
				System.exit(0);
				}
			}
		);
		//add a window listener to close the application
		addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                //System.out.println("Closed");
                e.getWindow().dispose();
				System.exit(0);
	            }
	        }
		);
		
	}
	

	/* (non-Javadoc)
	 * @see java.awt.Window#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g){
		// paint() is called after main() is called, 
		// which calls the constructor, 
		// which calls the start method of this class,
		// all of which run before the paint method is called
		 
		//send a String to the console
		System.out.println("The paint() method has been called.");

		//assign values to each primitive
		
		//byte	-128 to 127
		//short	-32768 to 32767
		//int	-2,147,483,648 to 2,147,483,647
		//long	-9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
		//float	+-1.4 * 10-45 to +-3.4 * 1038
		//double	+-4.9 * 10-324 to +-1.7 * 10308
		//char
		//boolean
		
		one = 127;
		three = 32767;
		five = 2147483647;
		seven = 9223369438985775806L;
		nine = (float)3.4 * 1038;
		eleven = 1.7 * 10308;
		thirteen = 191;
		fifteen = true;

		two = -2; //byte
		four = -4; //short
		six = -6; //int
		eight = -8; //long
		ten = -10; //float
		twelve = -12; //double
		fourteen = 230; //char
		sixteen = false; //boolean

		int margin = 70;
		int space = 15;

		g.drawString("one (" + byte.class + "): " + one, 30, space*1+margin);
		g.drawString("three (" + short.class + "): " + three, 30, space*2+margin);
		g.drawString("five (" + int.class + "): " + five, 30, space*3+margin);
		g.drawString("seven (" + long.class + "): " + seven, 30, space*4+margin);
		g.drawString("nine (" + float.class + "): " + nine, 30, space*5+margin);
		g.drawString("eleven (" + double.class + "): " + eleven, 30, space*6+margin);
		g.drawString("thirteen (" + char.class + "): " + thirteen, 30, space*7+margin);
		g.drawString("fifteen (" + boolean.class + "): " + fifteen, 30, space*8+margin);
		
		//draw another String on the frame
		g.drawString("Click the Close button, or anywhere else, to exit this application.", 30, 275);

		System.out.println("two (" + byte.class + "): " + two);
		System.out.println("four (" + short.class + "): " + four);
		System.out.println("six (" + int.class + "): " + six);
		System.out.println("eight (" + long.class + "): " + eight);
		System.out.println("ten (" + float.class + "): " + ten);
		System.out.println("twelve (" + double.class + "): " + twelve);
		System.out.println("fourteen (" + char.class + "): " + fourteen);
		System.out.println("sixteen (" + boolean.class + "): " + sixteen);
		
		//paint() is finished
		System.out.println("...all done");
		
	}


}
