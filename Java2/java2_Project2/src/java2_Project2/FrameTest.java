/**
 * 
 */
package java2_Project2;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author bbachmey
 * @instructions Add a project called java2_Project2 to the Java2_Homework working set. 
 * Add a class to your java2_Project2 project named FrameTest. 
 * In it, write a Java application which is displayed in a Frame. 
 * The application should declare 12 variables (all of type int) using proper syntax and naming conventions. 
 * Make them have values of 1 through 12, and then use the System class to print out the 
 *   names and respective values for 6 of them in the console. 
 * The names and respective values for the other 6 should be printed/displayed in the Frame. 
 * Make sure the user can close the frame without resorting to the Terminate Console choice. 
 *
 */
public class FrameTest extends Frame {
	//declare the String message
	private String message;
	//declare an array of integers
	private int[] arrayOfIntegers;
	
	/**
	 * @param args
	 * This is the first method called when the application is started
	 */
	public static void main(String[] args) {
		//declare an instance of the FrameTest class
		FrameTest ft;
		//instantiate the FrameTest object
		ft = new FrameTest();
		//call a custom method to "start" the application
		ft.arbitraryStartMethod();

	}
	
	/**
	 * default constructor for FrameTest class 
	 */
	public FrameTest() {
		//call the constructor of the superclass Frame
		//sending a String value sets the Title displayed in the window
		super("This is a Title");
	}
	
	/**
	 * This method is called from main(String[] args)
	 */
	public void arbitraryStartMethod() {

		//send a message to the console
		System.out.println("The arbitraryStartMethod() method has been called.");
		//set the size of the window
		setSize (500, 300);
		//make the window visible
		setVisible(true);
		//initialize the integer array previously declared as an instance variable
		//if the non-access modifier "static" were added, this would be a class variable
		arrayOfIntegers = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
		//initialize the String message
		message = "By extending the Frame class, this application is a Frame.";
		
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
	 * paint() is called after main() is called, 
	 * which calls the constructor, 
	 * which calls the start method of this class,
	 * all of which run before the paint method is called
	 */
	public void paint(Graphics g){
		//send a String to the console
		System.out.println("The paint() method has been called.");
		//draw the String message on the frame
		g.drawString(this.message,  30,  50);
		//draw another String on the frame
		g.drawString("Written here are the odd numbers in an array of 12 numbers.", 30, 70);
		//draw another String on the frame
		g.drawString("Click the Close button, or anywhere else, to exit this application.", 30, 275);
		//send a String to the console
		System.out.println("Here are the even numbers in an array of 12 numbers:");
		//loop through the 
		for (int i=0; i < arrayOfIntegers.length; i++){
			//assign the primitive int to an object of the Integer class, to get access to the .toString method
			Integer num = arrayOfIntegers[i];
			//odd ones go to the frame, even ones go to the console
			if (i % 2 == 0) {
				//draw the number on the frame
				g.drawString(num.toString() , 30, ((i*15)+100) );
			}
			else{
				//print the number on the console
				System.out.println(arrayOfIntegers[i]);	
			}
			
		}
		//the loop is finished
		System.out.println("...all done");
		
	}


}
