import java.util.HashMap;


public class Problem {
	
	private int problemNumber;
	private String problemTitle;
	private String problemStatement;
	private HashMap<Integer, MathValue> problemValues;


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

	public HashMap<Integer, MathValue> getProblemValues() {
		return problemValues;
	}

	public void setProblemValues(HashMap<Integer, MathValue> vari) {
		this.problemValues = vari;
	}

	public String getProblemStatement() {
		return problemStatement;
	}

	public void setProblemStatement(String problemStatement) {
		this.problemStatement = problemStatement;
	}


}
