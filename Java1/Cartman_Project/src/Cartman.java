import java.awt.*;
import java.util.ArrayList;

public class Cartman {
	//this is an ArrayList which holds the Cartman parts
	ArrayList<Part> parts = new ArrayList<Part>();
	
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
		
		//head
		this.setHead(new Head(
				Color.PINK,
				10,
				30,
				180,
				150
				));
		parts.add(head);
		
		//mouth
		this.setMouth(new Mouth(
				Color.BLACK, 
				head.getxPos()+66, 
				head.getyPos()+110
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

		//hat
		this.setHat(new Hat(
				Color.BLUE,
				head.getxPos(),
				head.getyPos(),
				head.getWidth(),
				((int)(head.getHeight())),
				0,
				180
				));
		parts.add(getHat());

		//left eye
		this.setLeftEye(new Eye(
				Color.WHITE,
				head.getxPos()+50,
				head.getyPos()+40,
				35,
				53
				));
		parts.add(getLeftEye());

		//right eye
		this.setRightEye(new Eye(
				Color.WHITE,
				leftEye.getxPos()+40,
				leftEye.getyPos(),
				35,
				53
				));
		parts.add(getRightEye());

		//left eyeball
		this.setLeftEyeBall(new EyeBall(
				Color.BLACK,
				leftEye.getxPos()+20,
				leftEye.getyPos()+22,
				6,
				6
				));
		parts.add(getLeftEyeBall());

		//right eyeball
		this.setRightEyeBall(new EyeBall(
				Color.BLACK,
				rightEye.getxPos()+9,
				rightEye.getyPos()+22,
				6,
				6
				));
		parts.add(getRightEyeBall());

		//hat ball
		this.setHatBall(new HatBall(
				Color.YELLOW,
				hat.getxPos()+65,
				hat.getyPos()-7,
				55,
				20
				));
		parts.add(getHatBall());

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
		parts.add(getHatTrim());


		//Part hatTrim = new HatTrim();
		//Part hatBall = new HatBall();
		
		
		//Part mouth = new Mouth();
		//Part body = new Body();
		//Part leftFoot = new Foot();
		//Part rightFoot = new Foot();
		//Part pants = new Pants();
		//Part button = new Button();
		//Part leftHand = new Hand();
		//Part rightHand = new Hand();

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

}
