import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class TrigApplet extends Applet implements ItemListener, ActionListener {
	
	private Problem problem;
	private Solution solution;
	private UnitCircle unitcircle;
	private Data dao;
	private MathGraph mg;
	
	
	@Override
	public void init(){
		//make a graph object
		mg = new MathGraph(
				20, //columns
				20, //rows
				30, //unit
				30 //margin
				);
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
		
		g.drawString("Hello World", 50, 50);
		
		mg.draw(g);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public Problem getProblem() {
		return problem;
	}

	public void setProblem(Problem problem) {
		this.problem = problem;
	}

	public Solution getSolution() {
		return solution;
	}

	public void setSolution(Solution solution) {
		this.solution = solution;
	}

	public UnitCircle getUnitcircle() {
		return unitcircle;
	}

	public void setUnitcircle(UnitCircle unitcircle) {
		this.unitcircle = unitcircle;
	}

	public Data getDao() {
		return dao;
	}

	public void setDao(Data dao) {
		this.dao = dao;
	}

	public MathGraph getGo() {
		return mg;
	}

	public void setGo(MathGraph go) {
		this.mg = go;
	}

}
