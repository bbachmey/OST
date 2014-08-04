import java.util.ArrayList;


public class Data {
	
	ArrayList<Problem> problems;
	ArrayList<Solution> solutions;
	
	public void init(){
		//build a set of problems
		
		//build a set of solutions
		
	}
	
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
