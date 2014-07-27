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
		parts.add(makeMouth());
		//TODO: makeMouth is called twice, it should only be called once, preferrably
		makeTeeth((Mouth)makeMouth());
		
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
		//get head coordinates
		//TODO: find another way to check for the head object in the parts array
		//	currently calling the get() method with 0 works, because head is the first
		//	part added to the array. The index of head could change, and this method would break.
		Head head = ((Head)parts.get(0));
		int x = head.getxPos();
		int y = head.getyPos();
		int w = head.getWidth();
		int h = head.getHeight();
		
		//chin
		Part chin = new Chin(
				Color.BLACK, 
				x + 25, 	//x
				y + 100, 	//y
				(int)(w-(w/3.5)),  	//w
				h / 4, 		//h
				-0, 		//start angle (where does the arc begin, relative to 3 o'clock?)
				-180);		//arc angle (how far around the circle from start does the arc go?)
		return chin;
	}

	/**
	 * @return
	 */
	private Part makeHead() {
		//head
		Part head = new Head(
				Color.PINK, 
				10, 	//x - this will be the anchor position for the other shapes on the face
				30, 	//y
				180, 	//w
				150);	//h
		parts.add(head);
		return head;
	}

	/**
	 * 
	 */
	private Part makeMouth() {
		//get head coordinates
		Head head = ((Head)parts.get(0));
		int x = head.getxPos();
		int y = head.getyPos();
		//mouth
		Part mouth = new Mouth(
				Color.BLACK,
				x+46,
				y+110
				);
		
		return mouth;
	}
	
	/**
	 * This method calls the makeTooth method a number of times to make a mouth full of teeth
	 * @return 
	 */
	private void makeTeeth(Mouth m){    	
		//figure out where the mouth is
		int x = m.getxPos();
		int y = m.getyPos();
		
		//make the first tooth
		parts.add(this.makeTooth(x+20, y));
		
		//make the second tooth
		parts.add(this.makeTooth(x+26, y));
		
		//make the third tooth
		parts.add(this.makeTooth(x+32, y));
		
		//make the fourth tooth
		parts.add(this.makeTooth(x+38, y));
		
	}
	/**
	 * @return
	 */
	private Part makeTooth(int x, int y) {
		//make a new Part
		Part tooth = new Tooth(
				Color.WHITE,
				x,		//x position
				y		//y position
				);
		return tooth;
	}

}
