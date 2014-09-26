
public class Main {

	public static void main(String[] args) {	   
		if (args.length > 0){
			double argd = Double.parseDouble(args[0]);
			System.out.println(argd);			
		}
		else {
			System.out.println("Use Run Configurations to enter a number in Program Arguments, and try again.");
		}
	}

}
