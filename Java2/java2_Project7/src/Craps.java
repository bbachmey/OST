
import java.applet.Applet;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 * @author bbachmey
 * @instructions Edit your Craps.java class from Lesson 7 
 * to allow the user to roll both dice with the press of a single button, 
 * then tell the user what they have rolled, and when they have 
 * rolled one of the following combinations:
 * 
 * snake eyes (two ones)
 * hard four (two twos)
 * easy eight (a five and a three)
 * 
 * You can tell them more combinations if you want. 
 * If it is not an "interesting" roll, prompt them to roll again. 
 * You can either reset the roll each time when they press the single "roll" button, 
 * or you can allow them to roll either of the die (cheat) until it happens 
 * to be a good roll. See http://en.wikipedia.org/wiki/Craps for more names. 
 *
 */
public class Craps extends Applet implements ActionListener {
	private Button die1;
	private Button die2;
	private Button both;
	private Button so;
	private int value1;
	private int value2;
	private int total;
	Scanner scan;
	private boolean comeout;
	private int point;
	private int xpos;
	private int ypos;
	private int spacer;

	@Override
	public void init() {
		//resize the window
		this.resize(300,300);
		
		//set the initial position of the text
		xpos = 50;
		ypos = 80;
		spacer = 15;
		
		//set the initial value of the dice
		value1 = 0;
		value2 = 0;

		//set the comeout value to true
		comeout = true;

		//make a new button
		both = new Button("Both");
		//add the Button to the Applet
		add(both);
		//add the Applet to the Button as an action listener
		both.addActionListener(this);
		
		//make a new button
		die1 = new Button("Die1");
		//add the Button to the Applet
		this.add(die1);
		//add the Applet to the Button as an action listener 
		die1.addActionListener(this);

		//make a new button
		die2 = new Button("Die2");
		//add the Button to the Applet
		add(die2);
		//add the Applet to the Button as an action listener
		die2.addActionListener(this);

		//make a new button
		so = new Button("Start Over");
		//add the Button to the Applet
		add(so);
		//add the Applet to the Button as an action listener
		so.addActionListener(this);

	}

	@Override
	public void paint(Graphics g) {

		if (total == 0){
			g.drawString("ROLL BOTH", xpos, ypos);
		}
		else {
			g.drawString("You rolled a " + value1, xpos, ypos);

			g.drawString("and a " + value2, xpos, ypos+spacer);

			g.drawString("For a total of " + total, xpos, ypos+(spacer*2));

			//initialize the Scanner
			scan = new Scanner(this.evaluate(value1, value2).toString()); 
			//initialize a counter
			int i = 0;
			//loop through the Scanner
			while (scan.hasNextLine() ){
				//increment the counter
				i++;
				//intialize a String with the next line in the Scanner
				String line = scan.nextLine();
				//send the String to the console
				System.out.println(line.toString());
				//draw the String on the Applet, incrementing the y-position
				g.drawString(line.toString(), xpos, ypos+50+(i*spacer));
			}
		}



	}

	private StringBuilder evaluate(int d1, int d2) {
		//declare the StringBuilder
		StringBuilder sb;

		//initialize the String builder
		sb = new StringBuilder();

		//2 - snake eyes (1,1)
		if ((d1==1) && (d2==1)){
			sb.append("SNAKE EYES");
			if (comeout){
				sb.append("\n");
				sb.append("You crapped out.");
				sb.append("\n");
				sb.append("Bets on the Pass Line lose.");
				sb.append("\n");
				sb.append("Bets on the Don't Pass Bar win.");
				sb.append("\n");
				sb.append("START OVER.");
			}
			else {
				sb.append("\n");
				sb.append("The point is " + point + ".");
				sb.append("\n");
				sb.append("Keep rolling.");
			}
		}

		//3 - ace deuce (1,2)(2,1)
		if (
				((d1==1) && (d2==2)) ||
				((d1==2) && (d2==1))
				){
			sb.append("ACE DEUCE");
			if (comeout){
				sb.append("\n");
				sb.append("You crapped out.");
				sb.append("\n");
				sb.append("Bets on the Pass Line lose.");
				sb.append("\n");
				sb.append("Bets on the Don't Pass Bar win.");
				sb.append("\n");
				sb.append("START OVER.");
			}
			else {
				sb.append("\n");
				sb.append("The point is " + point + ".");
				sb.append("\n");
				sb.append("Keep rolling.");
			}
		}

		//4 - easy four (1,3)(3,1)
		if (
				((d1==1) && (d2==3)) ||
				((d1==3) && (d2==1))
				){
			sb.append("EASY FOUR");
			if (comeout){
				point = total;
				sb.append("\n");
				sb.append("The point is set to " + point);
				sb.append("\n");
				sb.append("Keep rolling.");
			}
			else if (total == point) {
				sb.append("\n");
				sb.append("Pass Line bets win on " + point + "!");
				sb.append("\n");
				sb.append("Bets on the Don't Pass Bar lose.");
				sb.append("\n");
				sb.append("START OVER.");
			}
			else {
				sb.append("\n");
				sb.append("The point is " + point + ".");
				sb.append("\n");
				sb.append("Keep rolling.");
			}
		}

		//4 - hard four (2,2)
		if ((d1==2) && (d2==2)){
			sb.append("HARD FOUR");
			if (comeout){
				point = total;
				sb.append("\n");
				sb.append("The point is set to " + point);
				sb.append("\n");
				sb.append("Keep rolling.");
			}
			else if (total == point) {
				sb.append("\n");
				sb.append("Pass Line bets win on " + point + "!");
				sb.append("\n");
				sb.append("Bets on the Don't Pass Bar lose.");
				sb.append("\n");
				sb.append("START OVER.");
			}
			else {
				sb.append("\n");
				sb.append("The point is " + point + ".");
				sb.append("\n");
				sb.append("Keep rolling.");
			}
		}

		//5 - fever five (1,4)(2,3)(3,2)(4,1)
		if (
				((d1==1) && (d2==4)) ||
				((d1==2) && (d2==3)) ||
				((d1==3) && (d2==2)) ||
				((d1==4) && (d2==1))
				){
			sb.append("FEVER FIVE");
			if (comeout){
				point = total;
				sb.append("\n");
				sb.append("The point is set to " + point);
				sb.append("\n");
				sb.append("Keep rolling.");
			}
			else if (total == point) {
				sb.append("\n");
				sb.append("Pass Line bets win on " + point + "!");
				sb.append("\n");
				sb.append("Bets on the Don't Pass Bar lose.");
				sb.append("\n");
				sb.append("START OVER.");
			}
			else {
				sb.append("\n");
				sb.append("The point is " + point + ".");
				sb.append("\n");
				sb.append("Keep rolling.");
			}
		}

		//6 - easy six (1,5)(2,4)(4,2)(5,1)
		if (
				((d1==1) && (d2==5)) ||
				((d1==2) && (d2==4)) ||
				((d1==4) && (d2==2)) ||
				((d1==5) && (d2==1))
				){
			sb.append("EASY SIX");
			if (comeout){
				point = total;
				sb.append("\n");
				sb.append("The point is set to " + point);
				sb.append("\n");
				sb.append("Keep rolling.");
			}
			else if (total == point) {
				sb.append("\n");
				sb.append("Pass Line bets win on " + point + "!");
				sb.append("\n");
				sb.append("Bets on the Don't Pass Bar lose.");
				sb.append("\n");
				sb.append("START OVER.");
			}
			else {
				sb.append("\n");
				sb.append("The point is " + point + ".");
				sb.append("\n");
				sb.append("Keep rolling.");
			}
		}

		//6 - hard six (3,3)
		if ((d1==3) && (d2==3)){
			sb.append("HARD SIX");
			if (comeout){
				point = total;
				sb.append("\n");
				sb.append("The point is set to " + point);
				sb.append("\n");
				sb.append("Keep rolling.");
			}
			else if (total == point) {
				sb.append("\n");
				sb.append("Pass Line bets win on " + point + "!");
				sb.append("\n");
				sb.append("Bets on the Don't Pass Bar lose.");
				sb.append("\n");
				sb.append("START OVER.");
			}
			else {
				sb.append("\n");
				sb.append("The point is " + point + ".");
				sb.append("\n");
				sb.append("Keep rolling.");
			}
		}

		//7 - natural or seven out (1,6)(2,5)(3,4)(4,3)(5,2)(1,6)
		if (
				((d1==1) && (d2==6)) ||
				((d1==2) && (d2==5)) ||
				((d1==3) && (d2==4)) ||
				((d1==4) && (d2==3)) ||
				((d1==5) && (d2==2)) ||
				((d1==6) && (d2==1))
				){
			//comeout roll
			if (comeout){
				sb.append("SEVEN, FRONT LINE WINNER");
				sb.append("\n"); 
				sb.append("Pass Line bets win.");
				sb.append("\n");
				sb.append("Bets on the Don't Pass Bar lose.");
				sb.append("\n");
				sb.append("START OVER.");
			}
			else {
				sb.append("SEVEN OUT");
				sb.append("\n");
				sb.append("Pass Line bets lose.");
				sb.append("\n");
				sb.append("Bets on the Don't Pass bar win.");
				sb.append("\n");
				sb.append("START OVER.");		
			}
		}

		//8 - easy eight (2,6)(3,5)(5,3)(6,2)
		if (
				((d1==2) && (d2==6)) ||
				((d1==3) && (d2==5)) ||
				((d1==5) && (d2==3)) ||
				((d1==6) && (d2==2))
				){
			sb.append("EASY EIGHT");
			if (comeout){
				point = total;
				sb.append("\n");
				sb.append("The point is set to " + point);
				sb.append("\n");
				sb.append("Keep rolling.");
			}
			else if (total == point) {
				sb.append("\n");
				sb.append("Pass Line bets win on " + point + "!");
				sb.append("\n");
				sb.append("Bets on the Don't Pass Bar lose.");
				sb.append("\n");
				sb.append("START OVER.");
			}
			else {
				sb.append("\n");
				sb.append("The point is " + point + ".");
				sb.append("\n");
				sb.append("Keep rolling.");
			}
		}

		//8 - hard eight (4,4)
		if ((d1==4) && (d2==4)){
			sb.append("HARD EIGHT");
			if (comeout){
				point = total;
				sb.append("\n");
				sb.append("The point is set to " + point);
				sb.append("\n");
				sb.append("Keep rolling.");
			}
			else if (total == point) {
				sb.append("\n");
				sb.append("Pass Line bets win on " + point + "!");
				sb.append("\n");
				sb.append("Bets on the Don't Pass Bar lose.");
				sb.append("\n");
				sb.append("START OVER.");
			}
			else {
				sb.append("\n");
				sb.append("The point is " + point + ".");
				sb.append("\n");
				sb.append("Keep rolling.");
			}
		}

		//9 - nina (3,6)(4,5)(5,4)(6,3)
		if (
				((d1==3) && (d2==6)) ||
				((d1==4) && (d2==5)) ||
				((d1==5) && (d2==4)) ||
				((d1==6) && (d2==3))
				){
			sb.append("NINA");
			if (comeout){
				point = total;
				sb.append("\n");
				sb.append("The point is set to " + point);
				sb.append("\n");
				sb.append("Keep rolling.");
			}
			else if (total == point) {
				sb.append("\n");
				sb.append("Pass Line bets win on " + point + "!");
				sb.append("\n");
				sb.append("Bets on the Don't Pass Bar lose.");
				sb.append("\n");
				sb.append("START OVER.");
			}
			else {
				sb.append("\n");
				sb.append("The point is " + point + ".");
				sb.append("\n");
				sb.append("Keep rolling.");
			}
		}

		//10 - easy ten (4,6)(6,4)
		if (
				((d1==4) && (d2==6)) ||
				((d1==6) && (d2==4)) 

				){
			sb.append("EASY TEN");
			if (comeout){
				point = total;
				sb.append("\n");
				sb.append("The point is set to " + point);
				sb.append("\n");
				sb.append("Keep rolling.");
			}
			else if (total == point) {
				sb.append("\n");
				sb.append("Pass Line bets win on " + point + "!");
				sb.append("\n");
				sb.append("Bets on the Don't Pass Bar lose.");
				sb.append("\n");
				sb.append("START OVER.");
			}
			else {
				sb.append("\n");
				sb.append("The point is " + point + ".");
				sb.append("\n");
				sb.append("Keep rolling.");
			}
		}

		//10 - hard ten (5,5)
		if ((d1==5) && (d2==5)){
			sb.append("HARD TEN");
			if (comeout){
				point = total;
				sb.append("\n");
				sb.append("The point is set to " + point);
				sb.append("\n");
				sb.append("Keep rolling.");
			}
			else if (total == point) {
				sb.append("\n");
				sb.append("Pass Line bets win on " + point + "!");
				sb.append("\n");
				sb.append("Bets on the Don't Pass Bar lose.");
				sb.append("\n");
				sb.append("START OVER.");
			}
			else {
				sb.append("\n");
				sb.append("The point is " + point + ".");
				sb.append("\n");
				sb.append("Keep rolling.");
			}
		}

		//11 - yo-leven (5,6)(6,5)
		if (
				((d1==5) && (d2==6)) ||
				((d1==6) && (d2==5)) 
				){
			sb.append("YO-LEVEN");
			if (comeout){
				sb.append("\n");
				sb.append("Pass Line bets win on " + total + ".");
				sb.append("\n");
				sb.append("Bets on the Don't Pass Bar lose.");
				sb.append("\n");
				sb.append("START OVER.");
			}
			else {
				sb.append("\n");
				sb.append("The point is " + point + ".");
				sb.append("\n");
				sb.append("Keep rolling.");
			}
		}

		//12 - boxcars (6,6)
		if ((d1==6) && (d2==6)){
			sb.append("BOXCARS");
			if (comeout){
				sb.append("\n");
				sb.append("You crapped out.");
				sb.append("\n");
				sb.append("Bets on the Pass Line lose.");
				sb.append("\n");
				sb.append("Bets on the Don't Pass Bar are pushed.");
				sb.append("\n");
				sb.append("The house wins.");
				sb.append("\n");
				sb.append("START OVER.");
			}
			else {
				sb.append("\n");
				sb.append("The point is " + point + ".");
				sb.append("\n");
				sb.append("Keep rolling.");
			}
		}

		//comeout is no longer true after the first roll
		if (total > 0) comeout = false;

		return sb;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		//decide which die was rolled
		if (event.getActionCommand().toString() == "Die1"){
			value1 = (int)(Math.random() * 6) + 1;
		}
		else if  (event.getActionCommand().toString() == "Die2"){
			value2 = (int)(Math.random() * 6) + 1;
		}
		else if  (event.getActionCommand().toString() == "Start Over"){
			value1 = 0;
			value2 = 0;
			point = -1;
			comeout = true;
		}
		else {
			value1 = (int)(Math.random() * 6) + 1;
			value2 = (int)(Math.random() * 6) + 1;
		}

		//total the dice
		total = value1 + value2;


		//repaint the applet
		this.repaint();

	}

}
