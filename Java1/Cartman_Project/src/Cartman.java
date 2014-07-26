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
		
		Part chin = new Chin(Color.BLACK, 0, 0, 100, 25, -0, -180);
		
		parts.add(chin);
		
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
			//call the draw() method of the Part
			p.draw(g);
		}
		
	}

}
