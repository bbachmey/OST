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
		//return
		return sols;
	}

	private ArrayList<Problem> loadProblems() {
		//Local arraylist
		ArrayList<Problem> probs = new ArrayList<Problem>();
		
		// Manually set values for new solution objects
		Problem prob = new Problem();
		prob.setProblemNumber(0);
		prob.setProblemTitle("asdf");
		HashMap<Integer, String> vari = new HashMap<Integer, String>();
		vari.put(1, new String("do this"));
		vari.put(2, new String("then do this"));
		//prob.setProblemVariables(vari);
		
		//add the problem to the arraylist
		probs.add(prob);

		//return the problems
		return probs;
		
	}

	/**
	 * get a random problem
	 * @return Problem
	 */
	public Problem fetchProblem(){
		//Make a problem object
		Problem problem = new Problem();
		//get a random number from 0 to the number of Problems in the problems ArrayList
		int rint = (int)(Math.random() * this.getProblems().size());
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
