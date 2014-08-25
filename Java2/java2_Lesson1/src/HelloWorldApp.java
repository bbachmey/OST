import java.util.Properties;


/**
 * @author bbachmey
 *
 */
public class HelloWorldApp {

	/**
	 * 
	 */
	public HelloWorldApp() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hello World!");
		Properties props = System.getProperties();
		System.out.println(props.toString());
//		for (Properties prop : props){
//			System.out.println(prop.toString());
//		}
	}

}
