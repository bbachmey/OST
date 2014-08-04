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
	
	
	public void init(){
		dao = new Data();
		problem = dao.fetchProblem();
		solution = dao.fetchSolution(problem.getProblemNumber());
		
	}

	public void paint(Graphics g){
		
		g.drawString("Hello World", 50, 50);
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
