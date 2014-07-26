import java.awt.*;
import java.util.ArrayList;


public class Cartman {
	//the Graphics object becomes an attribute of Carman upon construction
	//this object is later used by the draw methods to do their drawing
	Graphics g;
	//this is an ArrayList which holds a list of Cartman parts
	//notice the polymorphisim in action!
	ArrayList<Part> parts = new ArrayList<Part>();
	
	/**
	 * @param graph
	 * This is the Cartman constructor
	 * This constructor method requires a Graphics object and return a Cartman
	 */
	public Cartman(Graphics graph){
		// put the Graphics object into an instance variable
		this.g = graph;
		// call the private method that creates each Cartman part
		this.makeMe();
	}
	
	
	/**
	 * This method is called by the constructor
	 */
	private void makeMe(){

		//head
		Part head = new Head(Color.PINK, 10, 30, 180, 150);
		parts.add(head);
		
		//chin
		Part chin = new Chin(Color.BLACK, 0, 0, 100, 25, -0, -180);
		parts.add(chin);
		
		
		//Part leftEye = new Eye();
		//Part rightEye = new Eye();
		//Part leftEyeball = new EyeBall();
		//Part rightEyeball = new EyeBall();
		//Part mouth = new Mouth();
		//Part tooth = new Tooth();		
		//Part body = new Body();
		//Part leftFoot = new Foot();
		//Part rightFoot = new Foot();
		//Part pants = new Pants();
		//Part button = new Button();
		//Part leftHand = new Hand();
		//Part rightHand = new Hand();
		//Part hat = new Hat();
		//Part hatTrim = new HatTrim();
		//Part hatBall = new HatBall();

	}

	/**
	 * @param partNum
	 * This method takes an integer and and calls the draw() method of an item in the ArrayList<Part> parts
	 * 
	 */
	public void drawPartOfMe(int partNum){
		parts.get(partNum).draw(g);
		
		}

	public void drawAllOfMe(){
		//Polymorphism in action!
		//	The draw() method of each object in the ArrayList<Part> parts is called
		//	and Java knows to execute the @Override draw() method of object in the ArrayList
		//	that extends the Part class
		for(Part p : parts){
			//get the color from the Part and set the color of the Graphics object
			g.setColor(p.getColor());
			//call the draw() method of the Part
			p.draw(g);
		}
		
	}

}
