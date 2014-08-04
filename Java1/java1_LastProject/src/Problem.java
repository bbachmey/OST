import java.util.HashMap;


public class Problem {
	
	private int problemNumber;
	private int problemTitle;
	private HashMap problemVariables;

	public Problem(int num, String title){
		
	}
	
	public Problem(int num, String title, HashMap pv){
		
	}

	public Problem() {
		// empty constructor
		
	}

	public int getProblemNumber() {
		return problemNumber;
	}

	public void setProblemNumber(int problemNumber) {
		this.problemNumber = problemNumber;
	}

	public int getProblemTitle() {
		return problemTitle;
	}

	public void setProblemTitle(int problemTitle) {
		this.problemTitle = problemTitle;
	}

	public HashMap getProblemVariables() {
		return problemVariables;
	}

	public void setProblemVariables(HashMap problemVariables) {
		this.problemVariables = problemVariables;
	}

}
