import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.text.NumberFormat;

/**
 * This is an applet that allows you to draw a circle or a square
 * @instructions On the applet, you should display the following information 
 * for the geometric figure drawn: area, perimeter, center point(x,y), top left corner(x,y) 
 * 
 * You may assume (for ease of computation) that any oval drawn is really a circle. 
 * 
 * In the ComputeFigure.java file, there are three classes. You should NOT edit 
 * the MouseHandler or the ButtonHandler classes. In fact, the only place you really 
 * need to edit is within the paint method of the ComputerFigure class. 
 * 
 * Note that you can draw the rectangle and circle in the paint method, so the 
 * information/variables needed to calculate its information is already there for you (x, y, width, height). 
 * 
 * Finally, the information should be nicely formatted. For example, 
 * output for the center point should be:
 * 
 * The center point is (45, 39)
 * 
 * This will take some fancy concatenation work using drawString to get the ( , ) 
 * since Java does not have a format for ordered pairs. 
 * 
 */
public class ComputeFigure extends Applet
{
	//gui elements
	Button circleButton;
	Button rectangleButton;
	TheMouseHandler mouseManager;
	TheButtonHandler buttonManager;
	Panel holdbuttons;

	//instance variables
	int x,y,height,width;
	String figure;

	double radius;
	double area;
	double perimeter;
	Point center;
	NumberFormat nf;


	public void init()
	{
		//resize the window
		this.resize(500, 400);
		//instantiate classes 
		mouseManager=new TheMouseHandler(this);
		buttonManager=new TheButtonHandler(this);
		holdbuttons=new Panel(); 
		circleButton=new Button("Circle");
		rectangleButton=new Button("Rectangle");


		//set initial default values
		figure="Circle";
		x=100;
		y=100;
		width=100;
		height=100;

		this.addMouseMotionListener(mouseManager);
		this.addMouseListener(mouseManager);

		circleButton.addActionListener(buttonManager);
		circleButton.setBackground(Color.red);

		rectangleButton.addActionListener(buttonManager);
		rectangleButton.setBackground(Color.green);

		this.setLayout(new BorderLayout());
		holdbuttons.add(circleButton);
		holdbuttons.add(rectangleButton);
		holdbuttons.setBackground(Color.LIGHT_GRAY);
		this.add("North",holdbuttons);
		//this.setBackground(Color.pink);
		this.setBackground(Color.white);


	}

	public void paint(Graphics g)
	{
		//instantite the Point object
		center = new Point(0,0);
		//set the decimal places of the NumberFormat
		nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);

		if(figure.equals("Circle") )
		{
			g.drawOval(x,y,width,height);

			//put computations here for circle
			//

			//radius = half the diameter
			radius = width / 2;

			//area = Pi * radius * radius
			area = Math.PI * radius * radius;

			//circumference = Pi * diameter
			perimeter = Math.PI * (radius + radius);

			//center = top left plus half the width and half the height
			center.setX(x + (width /2) );
			center.setY(y + (height /2) );

			//
			//end circle computations

		}
		else
		{
			g.drawRect(x,y,width,height);

			//put computations here for rectangle
			//

			//area = Pi * radius * radius
			area = width * height;

			//perimeter
			perimeter = (width * 2) + (height * 2);

			//center = top left plus half the width and half the height
			center.setX(x + (width /2) );
			center.setY(y + (height /2) );

			//
			//end Rectangle computations
		}

		g.drawString("Area: " + nf.format(area), x+(width/2)-40, y+height+25);
		g.drawString("Perimeter: " + nf.format(perimeter), x+width+3, y+height-3);
		g.drawString("Center point (x,y): (" + center.getX() +"," + center.getY() + ")", center.getX(), center.getY());
		g.drawString("Top left corner(x,y): (" + x + "," + y + ")", x, y-10);

	}
}



class Point {
	int x;
	int y;

	public Point(int x, int y){

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}

/**
 * 
 * class that handles mouse events keeping track of the 
 * mouse location and whether or not a button is pressed
 *
 */
class TheMouseHandler extends MouseAdapter 
{
	ComputeFigure theCurrentApplet;

	/**
	 * @param x
	 * Class constructor requires an instance of the applet. 
	 * 
	 */
	public  TheMouseHandler(ComputeFigure x)
	{
		theCurrentApplet=x;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mouseEntered(java.awt.event.MouseEvent)
	 * 
	 * This method causes the circle or rectangle to disappear when 
	 * the mouse hovers over the applet window
	 * 
	 */
	@Override
	public void mouseEntered(MouseEvent e)
	{
		//		theCurrentApplet.x=0;
		//		theCurrentApplet.y=0;
		//		theCurrentApplet.width=0;
		//		theCurrentApplet.height=0;
		//		theCurrentApplet.repaint(); 

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mouseExited(java.awt.event.MouseEvent)
	 * 
	 * This method   
	 * causes the circle or rectangle to disappear when
	 * the mouse exits the frame of the applet window
	 * 
	 */
	@Override
	public void mouseExited(MouseEvent e)
	{
		//		theCurrentApplet.x=0;
		//		theCurrentApplet.y=0;
		//		theCurrentApplet.width=0;
		//		theCurrentApplet.height=0;  
		//		theCurrentApplet.repaint();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mouseDragged(java.awt.event.MouseEvent)
	 * 
	 * This method calculates a value for width and height and calls repaint.
	 * It runs again and again and again as the mouse is dragged
	 * 
	 */
	@Override
	public void mouseDragged(MouseEvent e)
	{
		theCurrentApplet.width=e.getX()-theCurrentApplet.x;
		theCurrentApplet.height=e.getY()-theCurrentApplet.y;

		theCurrentApplet.repaint(); 
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mouseMoved(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseMoved(MouseEvent e)
	{ 
		//empty on purpose
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.MouseEvent)
	 * 
	 * This event sets the initial x,y values for the shape
	 * by recording where the mouse was pressed
	 * 
	 */
	@Override
	public void mousePressed(MouseEvent e)
	{ 
		theCurrentApplet.x=e.getX();
		theCurrentApplet.y=e.getY();  
	}
}


/**
 * @author bbachmey
 * This class implements the ActionListener interface and 
 * handles which button has been pushed by overriding the actionPerformed method
 *
 */
class TheButtonHandler implements ActionListener
{

	ComputeFigure CurrentApplet;

	/**
	 * @param x
	 * Class constructor requires an instance of the applet.
	 */
	public TheButtonHandler(ComputeFigure x)
	{
		CurrentApplet=x;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e)
	{

		System.out.println("Time to make a " + e.getActionCommand() + "!");
		CurrentApplet.figure=e.getActionCommand();

	}


}

