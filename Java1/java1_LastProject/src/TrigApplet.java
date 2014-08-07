import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;


public class TrigApplet extends Applet implements ItemListener, ActionListener {
	
	private Problem problem;
	private Solution solution;
	private Data dao;
	private ArrayList<MathShape> appletShapes;
	MathGraph mg;
	
	@Override
	public void init(){
		//initialize the math shapes array list
		appletShapes = new ArrayList<MathShape>();
//		//make a graph object
		mg = new MathGraph(
				3, //columns
				3, //rows
				160, //unit
				30 //margin
				);
		appletShapes.add(mg);
		
		//make a unit circle
		UnitCircle uc = new UnitCircle(
				mg.getCenter(),
				mg.getUnit()
				);
		appletShapes.add(uc);
		
		//make an arc
		
		
		//resize the window to fit the graph
		this.resize(
				(int)((mg.getColumns()*mg.getUnit())+(mg.getMargin()*2)),
				(int)((mg.getRows()*mg.getUnit())+(mg.getMargin()*2))
				);
		
		//make a data access object
		dao = new Data();
		//fetch a problem from the data access object
		problem = dao.fetchProblem();
		//fetch a corresponding solution from the data access object
		solution = dao.fetchSolution(problem.getProblemNumber());
		
	}

	@Override
	public void paint(Graphics g){
		
		g.drawString("Hello World", 120, 50);
		
		for (MathShape ms : appletShapes){
			ms.draw(g);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}






}
