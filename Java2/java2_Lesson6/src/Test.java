
public class Test {

	public static void main(String[] args) {
		int rem = 3;
		int i = 21;
		System.out.println("After declaring and setting to 21, i is " + i);
		System.out.println();
		
		//divide 2 into 21 and get the remainder (modulo)
		int j = i % rem;
		System.out.println("When i is " + i + " and j is set to \"i % " + rem + "\", the value of j is " + j);
		
		--i;
		j = i % rem;
		
		System.out.println("When i is " + i + " and j is set to \"i % " + rem + "\", the value of j is " + j);
		
		--i;
		j = i % rem;
		
		System.out.println("When i is " + i + " and j is set to \"i % " + rem + "\", the value of j is " + j);
		
		--i;
		j = i % rem;
		
		System.out.println("When i is " + i + " and j is set to \"i % " + rem + "\", the value of j is " + j);
		
		--i;
		j = i % rem;
		System.out.println("When i is " + i + " and j is set to \"i % " + rem + "\", the value of j is " + j);	       
	} 
	
}