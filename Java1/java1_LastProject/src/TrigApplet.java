import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.NumberFormat;
import java.util.ArrayList;


public class TrigApplet extends Applet implements ItemListener, ActionListener {

	private Problem problem;
	private Solution solution;
	private Data dao;
	private ArrayList<MathShape> appletShapes;
	MathGraph mg;
	UnitCircle uc;
	MathArc arc;
	TextField tfDegrees;
	TextField tfRadians;
	NumberFormat nf;
	double degrees;
	double radians;
	Graphics go;

	@Override
	public void init(){
		
		/* 
		 * DATA
		 */
		//set the initial degrees value
				degrees = 45;
				radians = Math.toRadians(degrees);

		//make a data access object
		dao = new Data();
		//fetch a problem from the data access object
		problem = dao.fetchProblem();
		//fetch a corresponding solution from the data access object
		solution = dao.fetchSolution(problem.getProblemNumber());
		
		
		/*
		 * SHAPES
		 */

		//initialize the math shapes array list
		appletShapes = new ArrayList<MathShape>();
		//make a graph object
		mg = new MathGraph(
				3, //columns
				3, //rows
				160, //unit
				30 //margin
				);
		appletShapes.add(mg);

		//make a unit circle
		uc = new UnitCircle(
				mg.getCenter(),
				mg.getUnit()
				);
		appletShapes.add(uc);

		//make an arc
		arc = new MathArc(
				mg.getCenter(),
				mg.getUnit(),
				45,
				Color.GREEN
				);
		appletShapes.add(arc);
		
		/*
		 * UI
		 */

		//resize the window to fit the graph
		this.resize(
				(int)((mg.getColumns()*mg.getUnit())+(mg.getMargin()*2)),
				(int)((mg.getRows()*mg.getUnit())+(mg.getMargin()*2))
				);
		
		//set the number format to an instance of NumberFormat
		this.setNf( NumberFormat.getInstance() );
		//set the maximum number of digits for number format in this applet
		this.getNf().setMaximumFractionDigits(4);
		
		//set the layout to null, to allow the text fields to be positioned
		this.setLayout(null);
		
		//create a new label and add it to this applet
		Label label = new Label("Degrees");
		label.setBounds(280, 30, 50, 20);
		this.add(label);
		//set the value of the degrees text field
		this.setTfDegrees(new TextField(String.valueOf(nf.format(degrees)), 15)); 
		//position the text field
		tfDegrees.setBounds(label.getBounds().x + label.getBounds().width+5,label.getBounds().y,60,20); 		
		//add the text field to this applet
		this.add(tfDegrees);
		
		//add this applet as an action listener to the text field
		this.tfDegrees.addActionListener(this);

		//reset the label
		label = new Label("Radians");
		label.setBounds(280, 60, 50, 20);
		this.add(label);  
		//set the value of the radians text field
		this.setTfRadians(new TextField(String.valueOf(nf.format(radians)), 15)); 
		//position the text field
		tfRadians.setBounds(label.getBounds().x + label.getBounds().width+5,label.getBounds().y,60,20); 		
		//add the text field to this applet
		this.add(tfRadians);

		//add this applet as an action listener to the text field
		this.tfRadians.addActionListener(this);

	}

	@Override
	public void paint(Graphics g){
		//make the Graphics object an attribute of this applet
		this.go = g;

		//go.drawString("Hello World", 120, 50);

		for (MathShape ms : appletShapes){
			ms.draw(go);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//cast the return value of e.getSource() into a local variable TextField 
		//  to determine which TextField on the applet sent the event
		TextField aetf = (TextField)e.getSource(); 
		//parse the text value into a double
		double givenNumber = Double.parseDouble(aetf.getText());
		//use an if statement to decide what to do in response
		//use the getText() method to change the value of 
		//  the corresponding instance variable
		if (aetf == tfDegrees) {
			//reset the degrees value
			this.degrees = givenNumber;
			//reset the radians value
			this.radians = Math.toRadians(degrees);
			//reset the text value of the text field
   		 	tfRadians.setText((String.valueOf(nf.format(this.radians))));
			//erase the unit circle
			uc.erase(go);
			//get the index value of the MathArc in the ArrayList
			int index = appletShapes.indexOf(arc);
			//assign the arc to a local variable
			MathArc temp = (MathArc) appletShapes.get(index);
			//change the angle on the arc
			temp.setAngle((int)degrees);

		}

		if (aetf == tfRadians) {
			//reset the radians value
			this.radians = givenNumber;
			//reset the degrees value
			this.degrees = Math.toDegrees(radians);
			//reset the text value of the text field
   		 	tfDegrees.setText((String.valueOf(nf.format(this.degrees))));
			//erase the unit circle
			uc.erase(go);
			//get the index value of the MathArc in the ArrayList			
			int index = appletShapes.indexOf(arc);
			//assign the arc to a local variable
			MathArc temp = (MathArc) appletShapes.get(index);
			//change the angle on the arc
			temp.setAngle((int)degrees);

		}

		//repaint the applet
		this.repaint();
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub

	}

	public TextField getTfDegrees() {
		return tfDegrees;
	}

	public void setTfDegrees(TextField tfDegrees) {
		this.tfDegrees = tfDegrees;
	}

	public TextField getTfRadians() {
		return tfRadians;
	}

	public void setTfRadians(TextField tfRadians) {
		this.tfRadians = tfRadians;
	}

	public NumberFormat getNf() {
		return nf;
	}

	public void setNf(NumberFormat nf) {
		this.nf = nf;
	}






}
