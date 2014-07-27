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
	 * This constructor method requires a Graphics object and returns a Cartman
	 */
	public Cartman(Graphics graph){
		// put the Graphics object into an instance variable
		this.g = graph;
		// call the private method that creates each Cartman part
		this.buildMe();
	}
	
	
	/**
	 * This method is called by the constructor
	 * The order that Parts are added to the ArrayList is the order in which they are drawn
	 */
	private void buildMe(){	
		
		parts.add(makeHead());
		//
		parts.add(makeChin());
		//
		parts.add(makeTooth());
		
		//Part leftEye = new Eye();
		//Part rightEye = new Eye();
		//Part leftEyeball = new EyeBall();
		//Part rightEyeball = new EyeBall();
		//Part mouth = new Mouth();
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


	public void drawAllOfMe(){
		//Polymorphism in action!
		//	The draw() method of each object in the ArrayList<Part> parts is called
		//	and Java knows to execute the @Override draw() method of the subclass object 
		// 	in the ArrayList that extends the Part class
		for(Part p : parts){
			//get the color from the Part object and set the color of the Graphics object
			g.setColor(p.getColor());
			//call the draw() method of the Part
			p.draw(g);
		}
		
	}


	/**
	 * @param partNum
	 * This method takes an integer and and calls the draw() method of an item in the ArrayList<Part> parts
	 * 
	 */
	public void drawPartOfMe(int partNum){
		parts.get(partNum).draw(g);
		
		}


	/**
	 * 
	 */
	private Part makeChin() {
		//chin
		Part chin = new Chin(
				Color.BLACK, 
				((Head)parts.get(0)).getxPos()+25, 	//x
				((Head)parts.get(0)).getyPos()+100, 		//y
				((Head)parts.get(0)).getWidth() / 5,  	//w
				((Head)parts.get(0)).getHeight() / 4, 	//h
				-0, 	//start angle
				-180);	//arc angle
		return chin;
	}

	/**
	 * @return
	 */
	private Part makeHead() {
		//head
		Part head = new Head(
				Color.PINK, 
				10, 	//x
				30, 	//y
				180, 	//w
				150);	//h
		parts.add(head);
		return head;
	}

	/**
	 * @return
	 */
	private Part makeTooth() {
		Part tooth = new Tooth(
				Color.WHITE,
				((Head)parts.get(0)).getxPos()+75,		//x position
				((Head)parts.get(0)).getyPos()+75		//y position
				);
		return tooth;
	}

}
