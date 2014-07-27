import java.awt.*;
import java.util.ArrayList;

public class Cartman {
	//this is an ArrayList which holds the Cartman parts
	ArrayList<Part> parts = new ArrayList<Part>();
	
	Head head;
	Mouth mouth;
	Chin chin;
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
	
	
	/**
	 * This is the Cartman constructor
	 * This constructor method requires a Graphics object and returns a Cartman
	 */
	public Cartman(){
		// call the private method that assembles the Cartman
		this.buildMe();
		
	}
	
	/**
	 * This method is called by the constructor
	 * The order that Parts are added to the ArrayList is the order in which they are drawn
	 */
	private void buildMe(){	
		
		//head
		this.setHead(makeHead(
				Color.PINK,
				10,
				30,
				180,
				150
				));
		parts.add(head);
		
		//chin
		this.setChin(makeChin(
				Color.BLACK, 
				head.getxPos()+25, 
				head.getyPos()+100,
				((int)(head.getHeight()/4)),
				((int)(head.getWidth()-(head.getWidth()/3.5))),				
				-0,
				-180
				));
		parts.add(chin);
		
		//mouth
		this.setMouth(makeMouth(
				Color.BLACK, 
				head.getxPos()+46, 
				head.getyPos()+110
				));
		parts.add(mouth);
		
		//first tooth
		this.setFirstTooth(makeTooth(
				(int)(mouth.getxPos()+(44*.17)), 
				mouth.getyPos()
				));
		parts.add(firstTooth);
		
		//second tooth
		this.setSecondTooth(makeTooth(
				(firstTooth.getxPos()+8), 
				firstTooth.getyPos()
				));
		parts.add(secondTooth);
		
		//third tooth
		this.setThirdTooth(makeTooth(
				(secondTooth.getxPos()+8), 
				secondTooth.getyPos()
				));
		parts.add(thirdTooth);
		
		//fourth tooth
		this.setFourthTooth(makeTooth(
				(thirdTooth.getxPos()+8), 
				thirdTooth.getyPos()
				));
		parts.add(fourthTooth);

		//left eye
		this.setLeftEye(makeEye(
				));
		parts.add(getLeftEye());

		//right eye
		this.setRightEye(makeEye(
				));
		parts.add(getRightEye());
		
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

	/**
	 * 
	 */
	private Chin makeChin(Color c, int x, int y, int h, int w, int sa, int aa) {
		//chin
		Chin chin = new Chin(
				c, 
				x, 
				y,
				w,
				h,
				sa,
				aa);
		return chin;
	}

	/**
	 * This method calls the makeTooth method a number of times to make a mouth full of teeth
	 * @return 
	 */
	private Eye makeEye(){    	
		Eye eye = new Eye(null, 0, 0, 0, 0);
		
		return eye;
		
	}
	
	/**
	 * @return
	 */
	private Head makeHead(Color c, int x, int y, int w, int h) {
		//head
		Head head = new Head(
				c, 
				x, 	//x - this will be the anchor position for the other shapes on the face
				y, 	//y
				w, 	//w
				h);	//h
		return head;
	}

	/**
	 * 
	 */
	private Mouth makeMouth(Color c, int x, int y) {
		//mouth
		Mouth mouth = new Mouth(
				c,
				x,
				y);
		return mouth;
	}
	

	/**
	 * @return
	 */
	private Tooth makeTooth(int x, int y) {
		//make a new Part
		Tooth tooth = new Tooth(
				Color.WHITE,
				x,		//x position
				y		//y position
				);
		return tooth;
	}

	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	public Mouth getMouth() {
		return mouth;
	}

	public void setMouth(Mouth mouth) {
		this.mouth = mouth;
	}

	public Eye getLeftEye() {
		return leftEye;
	}

	public void setLeftEye(Eye leftEye) {
		this.leftEye = leftEye;
	}

	public Eye getRightEye() {
		return rightEye;
	}

	public void setRightEye(Eye rightEye) {
		this.rightEye = rightEye;
	}

	public Hand getLeftHand() {
		return leftHand;
	}

	public void setLeftHand(Hand leftHand) {
		this.leftHand = leftHand;
	}

	public Hand getRightHand() {
		return rightHand;
	}

	public void setRightHand(Hand rightHand) {
		this.rightHand = rightHand;
	}

	public Pants getPants() {
		return pants;
	}

	public void setPants(Pants pants) {
		this.pants = pants;
	}

	public Shoe getLeftShoe() {
		return leftShoe;
	}

	public void setLeftShoe(Shoe leftShoe) {
		this.leftShoe = leftShoe;
	}

	public Shoe getRightShoe() {
		return rightShoe;
	}

	public void setRightShoe(Shoe rightShoe) {
		this.rightShoe = rightShoe;
	}

	public Hat getHat() {
		return hat;
	}

	public void setHat(Hat hat) {
		this.hat = hat;
	}

	public HatTrim getHatTrim() {
		return hatTrim;
	}

	public void setHatTrim(HatTrim hatTrim) {
		this.hatTrim = hatTrim;
	}

	public HatBall getHatBall() {
		return hatBall;
	}

	public void setHatBall(HatBall hatBall) {
		this.hatBall = hatBall;
	}

	public EyeBall getLeftEyeBall() {
		return leftEyeBall;
	}

	public void setLeftEyeBall(EyeBall leftEyeBall) {
		this.leftEyeBall = leftEyeBall;
	}

	public EyeBall getRightEyeBall() {
		return rightEyeBall;
	}

	public void setRightEyeBall(EyeBall rightEyeBall) {
		this.rightEyeBall = rightEyeBall;
	}

	public Tooth getFirstTooth() {
		return firstTooth;
	}

	public void setFirstTooth(Tooth firstTooth) {
		this.firstTooth = firstTooth;
	}

	public Tooth getSecondTooth() {
		return secondTooth;
	}

	public void setSecondTooth(Tooth secondTooth) {
		this.secondTooth = secondTooth;
	}

	public Tooth getThirdTooth() {
		return thirdTooth;
	}

	public void setThirdTooth(Tooth thirdTooth) {
		this.thirdTooth = thirdTooth;
	}

	public Tooth getFourthTooth() {
		return fourthTooth;
	}

	public void setFourthTooth(Tooth fourthTooth) {
		this.fourthTooth = fourthTooth;
	}

	public Button getFirstButton() {
		return firstButton;
	}

	public void setFirstButton(Button firstButton) {
		this.firstButton = firstButton;
	}

	public Button getSecondButton() {
		return secondButton;
	}

	public void setSecondButton(Button secondButton) {
		this.secondButton = secondButton;
	}

	public Button getThirdButton() {
		return thirdButton;
	}

	public void setThirdButton(Button thirdButton) {
		this.thirdButton = thirdButton;
	}

	public Chin getChin() {
		return chin;
	}

	public void setChin(Chin chin) {
		this.chin = chin;
	}

}
