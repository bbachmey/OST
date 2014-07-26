import java.awt.*;


public class Cartman {
	Graphics g;
	int numOfParts;
	
	/**
	 * @param graph
	 * This is the Cartman constructor
	 * This constructor method requires a Graphics object and return a Cartman
	 */
	public Cartman(Graphics graph){
		// put the Graphics object into an instance variable
		this.g = graph;
		// set the number of parts to be drawn
		// 	this is one less than the number of cases in the switch statement
		//	which makes case 14 a place to stash method calls that are not run
		numOfParts = 13;
	}
	
	/**
	 * This is the method that tells a Cartman to draw itself
	 * @param none
	 * @author bbachmey
	 */
	public void drawMe(){

		for(int i=0; i<numOfParts; i++ ){
			//call the drawPartOfMe method and pass it the loop increment
			this.drawPartOfMe(i);
		}
	
	}

	/**
	 * @param partNum
	 * This method takes an integer and feeds it to a switch statement,
	 * 	which excecutes another method specified within the case clase.
	 * This is not, I think the best way to call each method, but I looked
	 * 	at using Reflection, and was steered away from that.
	 * I do want a way to separate the instructions for drawing each part, 
	 * 	and I want a way to selectively call the method to draw each part,
	 * 	or to loop through and call them all. This is the best-first way I 
	 * 	decided to implement this idea.
	 */
	private void drawPartOfMe(int partNum){
		
		switch (partNum) 
		{
		case 0: 
			this.drawHead();
			break;
		case 1: 
			this.drawEyes();
			break;
		case 2: 
			this.drawEyeBalls();
			break;
		case 3: 
			this.drawMouth();
			break;
		case 4: 
			this.drawTeeth();
			break;
		case 5: 
			
			break;
		case 6: 
			
			break;
		case 7: 
			
			break;
		case 8: 
			
			break;
		case 9: 
			
			break;
		case 10: 
			
			break;
		case 11: 
			
			break;
		case 12: 
			
			break;
		case 13: 
			
			
			
			
			
			this.drawBody();
			this.drawFeet();
			this.drawPants();
			this.drawButtons();
			this.drawHands();
			this.drawChin();
			this.drawHat();
			this.drawTrim();
			this.drawHatBall();
			break;
			
			
		}

	}
	
	/**
	 * Draw the eye balls
	 */
	private void drawEyeBalls(){
		//set color
		g.setColor(Color.BLACK);
		//anchor position (left eye)
		int x = 63;
		int y = 86;
		//relative width and height
		int w = 10;
		int h = 10;
		//draw the oval
		g.fillOval(x,y,w,h);
		//anchor position (right eye)
		x = 90;
		//draw the oval again	
		g.fillOval(x,y,w,h);
	}
	
	/**
	 *  
	 */
	private void drawEyes(){
		g.setColor(Color.white);
		g.fillOval(50, 66, 35, 53);
		g.fillOval(78,66,35,53);
	}

	/**
	 * 
	 */
	private void drawMouth(){
		g.setColor(Color.black);
		int [] xValues = {56,89,109};
		int [] yValues = {140,150,140};
		Polygon shapeThing = new Polygon(xValues, yValues, 3);
		//g.fillPolygon(xValues, yValues, 3);
		g.fillPolygon(shapeThing); /** this is an example of polymorphism **/
	
	}

	/**
	 *  
	 */
	private void drawTeeth(){
		//set color
		g.setColor(Color.WHITE);
		//anchor position
		int x = 0;
		int y = 0;
		//relative position
		int [] xValues = {x+56,x+89,x+109};
		int [] yValues = {y+140,y+150,y+140};
		//make a polygon
		Polygon p = new Polygon(xValues, yValues, xValues.length);
		//draw the polygon
		g.fillPolygon(p);
		
	}

	/**
	 *  
	 */
	private void drawHead(){
		//set color
		g.setColor(Color.PINK);
		//anchor position
		int x = 10;
		int y = 30;
		//relative width and height
		int w = 180;
		int h = 150;
		//draw the oval
		g.fillOval(x,y,w,h);
	}

	/**
	 *  
	 */
	private void drawBody(){
		//set color
		g.setColor(Color.WHITE);
		//anchor position
		int x = 0;
		int y = 0;
		//relative position
		int [] xValues = {x+56,x+89,x+109};
		int [] yValues = {y+140,y+150,y+140};
		//make a polygon
		Polygon p = new Polygon(xValues, yValues, xValues.length);
		//draw the polygon
		g.fillPolygon(p);
	}

	/**
	 *  
	 */
	private void drawFeet(){
		//set color
		g.setColor(Color.WHITE);
		//anchor position
		int x = 0;
		int y = 0;
		//relative position
		int [] xValues = {x+56,x+89,x+109};
		int [] yValues = {y+140,y+150,y+140};
		//make a polygon
		Polygon p = new Polygon(xValues, yValues, xValues.length);
		//draw the polygon
		g.fillPolygon(p);
	}

	/**
	 *  
	 */
	private void drawPants(){
		//set color
		g.setColor(Color.WHITE);
		//anchor position
		int x = 0;
		int y = 0;
		//relative position
		int [] xValues = {x+56,x+89,x+109};
		int [] yValues = {y+140,y+150,y+140};
		//make a polygon
		Polygon p = new Polygon(xValues, yValues, xValues.length);
		//draw the polygon
		g.fillPolygon(p);
	}

	/**
	 *  
	 */
	private void drawButtons(){
		//set color
		g.setColor(Color.PINK);
		//anchor position
		int x = 10;
		int y = 30;
		//relative width and height
		int w = 180;
		int h = 150;
		//draw the oval
		g.fillOval(x,y,w,h);
	}

	/**
	 * 
	 */
	private void drawHands(){
		//set color
		g.setColor(Color.WHITE);
		//anchor position
		int x = 0;
		int y = 0;
		//relative position
		int [] xValues = {x+56,x+89,x+109};
		int [] yValues = {y+140,y+150,y+140};
		//make a polygon
		Polygon p = new Polygon(xValues, yValues, xValues.length);
		//draw the polygon
		g.fillPolygon(p);
	}

	/**
	 *  
	 */
	private void drawChin(){
		//set color
		g.setColor(Color.WHITE);
		//anchor position
		int x = 0;
		int y = 0;
		//relative position
		int [] xValues = {x+56,x+89,x+109};
		int [] yValues = {y+140,y+150,y+140};
		//make a polygon
		Polygon p = new Polygon(xValues, yValues, xValues.length);
		//draw the polygon
		g.fillPolygon(p);
	}

	/**
	 *  
	 */
	private void drawHat(){
		//set color
		g.setColor(Color.WHITE);
		//anchor position
		int x = 0;
		int y = 0;
		//relative position
		int [] xValues = {x+56,x+89,x+109};
		int [] yValues = {y+140,y+150,y+140};
		//make a polygon
		Polygon p = new Polygon(xValues, yValues, xValues.length);
		//draw the polygon
		g.fillPolygon(p);
	}

	/**
	 *  
	 */
	private void drawTrim(){
		//set color
		g.setColor(Color.WHITE);
		//anchor position
		int x = 0;
		int y = 0;
		//relative position
		int [] xValues = {x+56,x+89,x+109};
		int [] yValues = {y+140,y+150,y+140};
		//make a polygon
		Polygon p = new Polygon(xValues, yValues, xValues.length);
		//draw the polygon
		g.fillPolygon(p);
	}

	/**
	 *  
	 */ 
	private void drawHatBall(){
		//set color
		g.setColor(Color.WHITE);
		//anchor position
		int x = 0;
		int y = 0;
		//relative position
		int [] xValues = {x+56,x+89,x+109};
		int [] yValues = {y+140,y+150,y+140};
		//make a polygon
		Polygon p = new Polygon(xValues, yValues, xValues.length);
		//draw the polygon
		g.fillPolygon(p);
	}





	
}
