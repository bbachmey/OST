import java.util.ArrayList;
import java.util.HashMap;


public class Data {
	
	ArrayList<Problem> problems;
	ArrayList<Solution> solutions;
	
	/**
	 * empty constructor
	 */
	public Data(){
		//initialize problems with the return value of method with manual problem entries
		problems = loadProblems();
		//initialize solutions with the return value of method with manual solution entries
		solutions = loadSolutions();
		
	}

	private ArrayList<Problem> loadProblems() {
		
		//Local arraylist
		ArrayList<Problem> probs = new ArrayList<Problem>();
		
		//2.1.ex.1 A Point on the Unit Circle
		Problem prob = new Problem();
		prob.setProblemNumber(0);
		prob.setProblemTitle("A Point on the Unit Circle");
		prob.setProblemStatement("Show that the point is on the unit circle.");
		HashMap<Integer, MathValue> vari = new HashMap<Integer, MathValue>();
		vari.put(0, new MathPoint(
				(Math.sqrt(3)/3),
				(Math.sqrt(6)/3)
				));
		prob.setProblemValues(vari);
		
		//add the problem to the arraylist
		probs.add(prob);
		//2.1.ex.2 Locating a Point on the Unit Circle
		//2.1.ex.3 Finding Terminal Points
		//2.1.ex.4 Finding Terminal Points
		//2.1.ex.5 Finding Reference Numbers
		//2.1.ex.6 Using Reference Numbers to Find Terminal Points
		//2.1.ex.7 Finding Terminal Points for Large t
		
		
		
		
		
		
		// Manually set values for new solution objects
		prob = new Problem();
		prob.setProblemNumber(1);
		prob.setProblemTitle("asdf");
		vari = new HashMap<Integer, MathValue>();
		vari.put(1, new MathPoint(1.2, 3.3));

		prob.setProblemValues(vari);
		
		//add the problem to the arraylist
		probs.add(prob);

		//return the problems
		return probs;
		
	}

	private ArrayList<Solution> loadSolutions() {
		// Local ArrayList
		ArrayList<Solution> sols = new ArrayList<Solution>();
		

		// Manually set values for new solution objects
		Solution sol = new Solution();
		sol.setSolutionNumber(0);
		sol.setSolutionTitle("asdf");
		HashMap<Integer, String> steps = new HashMap<Integer, String>();
		steps.put(1, new String("do this"));
		steps.put(2, new String("then do this"));
		sol.setSteps(steps);
		sols.add(sol);
		
		// Manually set values for new solution objects
		sol = new Solution();
		sol.setSolutionNumber(1);
		sol.setSolutionTitle("asasdfasdfdf");
		steps = new HashMap<Integer, String>();
		steps.put(1, new String("do this"));
		steps.put(2, new String("then do this"));
		sol.setSteps(steps);
		sols.add(sol);
		
		
		
		
		//return
		return sols;
	}

	/**
	 * get a random problem
	 * @return Problem
	 */
	public Problem fetchProblem(){
		//Make a problem object
		Problem problem = new Problem();
		//get a random number from 0 to the number of Problems in the problems ArrayList
		int size = this.getProblems().size();
		double rand = Math.random();
		int rint = (int)(rand * size);
		//get the problem
		problem = problems.get(rint);
		//return the problem
		return problem;
	}
	
	/**
	 * @param index
	 * @return
	 */
	public Problem fetchProblem(int index){
		Problem problem = new Problem();
		problem = problems.get(index);
		return problem;
	}
	
	public Solution fetchSolution(int index){
		Solution solution = new Solution();
		solution = solutions.get(index);
		return solution;
	}
	
	public ArrayList<Problem> getProblems() {
		return problems;
	}
	public void setProblems(ArrayList<Problem> problems) {
		this.problems = problems;
	}
	public ArrayList<Solution> getSolutions() {
		return solutions;
	}
	public void setSolutions(ArrayList<Solution> solutions) {
		this.solutions = solutions;
	}

}
