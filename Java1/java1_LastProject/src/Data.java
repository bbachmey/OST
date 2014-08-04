import java.util.ArrayList;


public class Data {
	
	ArrayList<Problem> problems;
	ArrayList<Solution> solutions;
	
	public void init(){
		//build a set of problems
		
		//build a set of solutions
		
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
