package salesGUI;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// The SalesApp class is the Model and the Controller for this application
		SalesApp newApp = new SalesApp();
		
		// The SalesUserInterface class is the View for this application
		SalesUserInterface appFrame = new SalesUserInterface(newApp);

	}

}
