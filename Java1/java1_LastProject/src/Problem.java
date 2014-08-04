import java.util.HashMap;


public class Problem {
	
	private int problemNumber;
	private String problemTitle;
	private HashMap<Integer, String> problemVariables;


	/**
	 * empty constructor
	 */
	public Problem() {
		
		
	}
	
	public Problem(int num, String title){
		
	}
	
	public Problem(int num, String title, HashMap pv){
		
	}


	public int getProblemNumber() {
		return problemNumber;
	}

	public void setProblemNumber(int problemNumber) {
		this.problemNumber = problemNumber;
	}

	public String getProblemTitle() {
		return problemTitle;
	}

	public void setProblemTitle(String problemTitle) {
		this.problemTitle = problemTitle;
	}

	public HashMap<Integer, String> getProblemVariables() {
		return problemVariables;
	}

	public void setProblemVariables(HashMap<Integer, String> problemVariables) {
		this.problemVariables = problemVariables;
	}

}
