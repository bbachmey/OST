import java.awt.*;
import java.util.ArrayList;

public class Cartman {
	//this is an ArrayList which holds the Cartman parts
	ArrayList<Part> parts = new ArrayList<Part>();
	
	Body body;
	Head head;
	Mouth mouth;
	Chin firstChin;
	Chin secondChin;
	Eye leftEye;
	Eye rightEye;
	Hand leftHand;
	Hand rightHand;
	Pants pants;
	Shoe leftShoe;
	Shoe rightShoe;
	Hat hat;
	HatTrim hatTrim;
	HatBall hatBall;
	EyeBall leftEyeBall;
	EyeBall rightEyeBall;
	Tooth firstTooth;
	Tooth secondTooth;
	Tooth thirdTooth;
	Tooth fourthTooth;
	Button firstButton;
	Button secondButton;
	Button thirdButton;
	
	Shape headClip;
	
	/**
	 * This is the Cartman constructor
	 * This constructor method requires a Graphics object and returns a Cartman
	 */
	public Cartman(){
		// call the private method that assembles Cartman
		this.buildMe();
		
	}
	
	/**
	 * This method is called by the constructor
	 * The order that Parts are added to the ArrayList is the order in which they are drawn
	 */
	private void buildMe(){	
		

		//pants
		this.setPants(new Pants(
				Color.GRAY, 
				30,  //x
				218, //y
				(new int [] {0, 200, 185, 15}), //xArr
				(new int [] {0, 0, 45, 45})     //yArr
				
				));
		parts.add(pants);

		//left shoe
		this.setLeftShoe(new Shoe(
				Color.BLACK,
				pants.getxPos()+10, //x
				pants.getyPos()+38, //y
				(int)((pants.getBottomWidth()/2)*(1.115)), //w
				20, //h
				0, //sa
				180 //aa
				));
		parts.add(leftShoe);

		//right shoe
		this.setRightShoe(new Shoe(
				Color.BLACK,
				leftShoe.getxPos()+leftShoe.getWidth()-7,
				leftShoe.getyPos(), //y
				leftShoe.getWidth(), //w
				leftShoe.getHeight(), //h
				0,
				180
				));
		parts.add(rightShoe);
		
		//body
		this.setBody(new Body(
				Color.RED,
				pants.getxPos()-10,  //x
				pants.getyPos()-88, //y
				220, //w
				125  //h
				));
		parts.add(body);

		//left hand
		this.setLeftHand(new Hand(
				Color.YELLOW,
				body.getxPos()-10,  //x
				body.getyPos()+10, //y
				40, //w
				40  //h
				));
		parts.add(leftHand);

		//right hand
		this.setRightHand(new Hand(
				Color.YELLOW,
				body.getxPos()+body.getWidth()-30, //x
				body.getyPos()+40, //y
				40, //w
				40  //h
				));
		parts.add(rightHand);

		//first button
		this.setFirstButton(new Button(
				Color.BLACK,
				body.getxPos()+(body.getWidth()/2), //x
				body.getyPos()+65, //y
				3, //w
				8  //h
				));
		parts.add(firstButton);

		//second button
		this.setSecondButton(new Button(
				Color.BLACK,
				firstButton.getxPos()+2, //x
				firstButton.getyPos()+20, //y
				3, //w
				8  //h
				));
		parts.add(secondButton);

		//third button
		this.setThirdButton(new Button(
				Color.BLACK,
				secondButton.getxPos()-1, //x
				secondButton.getyPos()+20, //y
				3, //w
				8  //h
				));
		parts.add(thirdButton);
		
		//whole head
				this.setHead(new Head(
						Color.PINK,
						body.getxPos()+((body.getWidth()-180)/2) ,
						body.getyPos()-90,
						180, //w
						150,  //h
						headClip
						));
				parts.add(head);
				
		//hat
		this.setHat(new Hat(
				Color.BLUE,
				body.getxPos()+((body.getWidth()-180)/2) ,
				body.getyPos()-90,
				180, //w
				150, //h
				0,
				180
				));
		parts.add(hat);
		
		//hat ball
		this.setHatBall(new HatBall(
				Color.YELLOW,
				hat.getxPos()+65,
				hat.getyPos()-7,
				55,
				20
				));
		parts.add(hatBall);

		//hat trim
		this.setHatTrim(new HatTrim(
				Color.YELLOW,
				hat.getxPos()+2,
				hat.getyPos()+37,
				hat.getWidth()-4,
				55, 
				0, 
				180
				));
		parts.add(hatTrim);

		//hat trim two
		this.setHatTrim(new HatTrim(
				Color.YELLOW,
				hat.getxPos()+2,
				hat.getyPos()+36,
				hat.getWidth()-4,
				55, 
				0, 
				180
				));
		parts.add(hatTrim);
		
		//hat trim three
		this.setHatTrim(new HatTrim(
				Color.YELLOW,
				hat.getxPos()+2,
				hat.getyPos()+35,
				hat.getWidth()-4,
				55, 
				0, 
				180
				));
		parts.add(hatTrim);
		
		//hat trim four
		this.setHatTrim(new HatTrim(
				Color.YELLOW,
				hat.getxPos()+2,
				hat.getyPos()+38,
				hat.getWidth()-4,
				55, 
				0, 
				180
				));
		parts.add(hatTrim);
		
		//hat trim five
		this.setHatTrim(new HatTrim(
				Color.YELLOW,
				hat.getxPos()+2,
				hat.getyPos()+39,
				hat.getWidth()-4,
				55, 
				0, 
				180
				));
		parts.add(hatTrim);
		
		//hat trim six
		this.setHatTrim(new HatTrim(
				Color.YELLOW,
				hat.getxPos()+2,
				hat.getyPos()+34,
				hat.getWidth()-4,
				55, 
				0, 
				180
				));
		parts.add(hatTrim);

	    //head clip
	    this.setHeadClip(
	    		//this is an oval Shape
	    		//this Shape is used to clip the drawing of the head
	    		//so that the head is not drawn over the hat
	    		new java.awt.geom.Ellipse2D.Float(
	    				hat.getxPos(), //float x
	    				hat.getyPos()+38, //float y
	    				hat.getWidth(), //float w
	    				65 //float h
	    				));
	    
		//clipped head
		this.setHead(new Head(
				Color.PINK,
				body.getxPos()+((body.getWidth()-180)/2) ,
				body.getyPos()-90,
				180, //w
				150,  //h
				headClip
				));
		parts.add(head);
		
		//mouth
		this.setMouth(new Mouth(
				Color.BLACK, 
				head.getxPos()+66, 
				head.getyPos()+115,
				(new int [] {0, 22, 44}), 
				(new int [] {0, 16, 0})
				
				));
		parts.add(mouth);

		//first chin
		this.setFirstChin(new Chin(
				Color.BLACK, 
				mouth.getxPos()+10, 
				mouth.getyPos()+14,
				21,
				5,				
				-0,
				-140
				));
		parts.add(firstChin);

		//second chin
		this.setSecondChin(new Chin(
				Color.BLACK, 
				head.getxPos()+25, 
				head.getyPos()+86,
				((int)(head.getWidth()-(head.getWidth()/3.5))),	
				((int)(head.getHeight()*.38)),			
				-20,
				-140
				));
		parts.add(secondChin);
		
		//first tooth
		this.setFirstTooth(new Tooth(
				Color.WHITE,
				(int)(mouth.getxPos()+(44*.17)), 
				mouth.getyPos()
				));
		parts.add(firstTooth);
		
		//second tooth
		this.setSecondTooth(new Tooth(
				Color.WHITE,
				(firstTooth.getxPos()+8), 
				firstTooth.getyPos()
				));
		parts.add(secondTooth);
		
		//third tooth
		this.setThirdTooth(new Tooth(
				Color.WHITE,
				(secondTooth.getxPos()+8), 
				secondTooth.getyPos()
				));
		parts.add(thirdTooth);
		
		//fourth tooth
		this.setFourthTooth(new Tooth(
				Color.WHITE,
				(thirdTooth.getxPos()+8), 
				thirdTooth.getyPos()
				));
		parts.add(fourthTooth);

		//left eye
		this.setLeftEye(new Eye(
				Color.WHITE,
				head.getxPos()+50,
				head.getyPos()+50,
				40, //w
				53 //h
				));
		parts.add(leftEye);

		//right eye
		this.setRightEye(new Eye(
				Color.WHITE,
				leftEye.getxPos()+40,
				leftEye.getyPos(),
				leftEye.getWidth(),
				leftEye.getHeight()
				));
		parts.add(rightEye);

		//left eyeball
		this.setLeftEyeBall(new EyeBall(
				Color.BLACK,
				leftEye.getxPos()+20,
				leftEye.getyPos()+22,
				6,
				6
				));
		parts.add(leftEyeBall);

		//right eyeball
		this.setRightEyeBall(new EyeBall(
				Color.BLACK,
				rightEye.getxPos()+9,
				rightEye.getyPos()+22,
				6,
				6
				));
		parts.add(rightEyeBall);


	}

	public void drawAllOfMe(Graphics g){
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
	public void drawPartOfMe(Graphics g, int partNum){
		parts.get(partNum).draw(g);
		
		}


	public Button getFirstButton() {
		return firstButton;
	}

	public Chin getFirstChin() {
		return firstChin;
	}
	
	public Tooth getFirstTooth() {
		return firstTooth;
	}

	public Tooth getFourthTooth() {
		return fourthTooth;
	}
	
	public Hat getHat() {
		return hat;
	}

	public HatBall getHatBall() {
		return hatBall;
	}

	public HatTrim getHatTrim() {
		return hatTrim;
	}

	public Head getHead() {
		return head;
	}

	public Eye getLeftEye() {
		return leftEye;
	}

	public EyeBall getLeftEyeBall() {
		return leftEyeBall;
	}

	public Hand getLeftHand() {
		return leftHand;
	}

	public Shoe getLeftShoe() {
		return leftShoe;
	}

	public Mouth getMouth() {
		return mouth;
	}

	public Pants getPants() {
		return pants;
	}

	public ArrayList<Part> getParts() {
		return parts;
	}

	public Eye getRightEye() {
		return rightEye;
	}

	public EyeBall getRightEyeBall() {
		return rightEyeBall;
	}

	public Hand getRightHand() {
		return rightHand;
	}

	public Shoe getRightShoe() {
		return rightShoe;
	}

	public Button getSecondButton() {
		return secondButton;
	}

	public Chin getSecondChin() {
		return secondChin;
	}

	public Tooth getSecondTooth() {
		return secondTooth;
	}

	public Button getThirdButton() {
		return thirdButton;
	}

	public Tooth getThirdTooth() {
		return thirdTooth;
	}

	public void setFirstButton(Button firstButton) {
		this.firstButton = firstButton;
	}

	public void setFirstChin(Chin firstChin) {
		this.firstChin = firstChin;
	}

	public void setFirstTooth(Tooth firstTooth) {
		this.firstTooth = firstTooth;
	}

	public void setFourthTooth(Tooth fourthTooth) {
		this.fourthTooth = fourthTooth;
	}

	public void setHat(Hat hat) {
		this.hat = hat;
	}

	public void setHatBall(HatBall hatBall) {
		this.hatBall = hatBall;
	}

	public void setHatTrim(HatTrim hatTrim) {
		this.hatTrim = hatTrim;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	public void setLeftEye(Eye leftEye) {
		this.leftEye = leftEye;
	}

	public void setLeftEyeBall(EyeBall leftEyeBall) {
		this.leftEyeBall = leftEyeBall;
	}

	public void setLeftHand(Hand leftHand) {
		this.leftHand = leftHand;
	}

	public void setLeftShoe(Shoe leftShoe) {
		this.leftShoe = leftShoe;
	}

	public void setMouth(Mouth mouth) {
		this.mouth = mouth;
	}

	public void setPants(Pants pants) {
		this.pants = pants;
	}

	public void setParts(ArrayList<Part> parts) {
		this.parts = parts;
	}

	public void setRightEye(Eye rightEye) {
		this.rightEye = rightEye;
	}

	public void setRightEyeBall(EyeBall rightEyeBall) {
		this.rightEyeBall = rightEyeBall;
	}

	public void setRightHand(Hand rightHand) {
		this.rightHand = rightHand;
	}

	public void setRightShoe(Shoe rightShoe) {
		this.rightShoe = rightShoe;
	}

	public void setSecondButton(Button secondButton) {
		this.secondButton = secondButton;
	}

	public void setSecondChin(Chin secondChin) {
		this.secondChin = secondChin;
	}

	public void setSecondTooth(Tooth secondTooth) {
		this.secondTooth = secondTooth;
	}

	public void setThirdButton(Button thirdButton) {
		this.thirdButton = thirdButton;
	}

	public void setThirdTooth(Tooth thirdTooth) {
		this.thirdTooth = thirdTooth;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public Shape getHeadClip() {
		return headClip;
	}

	public void setHeadClip(Shape headClip) {
		this.headClip = headClip;
	}

}
