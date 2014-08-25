
public class Quiz {

	public static void main(String[] args) {

		//		boolean o1;
		//		boolean o2;
		//		boolean o3;
		//		boolean result;
		//		
		//		o1 = true;
		//		o2 = false;
		//		o3 = false;
		//		
		//		result = ((o1 || o2) && !o3); 
		//		
		//		System.out.println(result);

		int x = 100;

		if (x <= 200){
			if (x < 100) {
				if (x <= 0 ){
					System.out.println("A");
				}
				else {
					System.out.println("B");
				}					
			}				
			else {
				System.out.println("C");
			}				
		}
		else{
			System.out.println("D");
		}

		boolean result;
		
		x = -1;
		result = ( (x >1 && x <100) || (x<0) );
		System.out.println(result);

		x = 0;
		result = ( (x >1 && x <100) || (x<0) );
		System.out.println(result);

		x = 1;
		result = ( (x >1 && x <100) || (x<0) );
		System.out.println(result);

		x = 2;
		result = ( (x >1 && x <100) || (x<0) );
		System.out.println(result);

		x = 99;
		result = ( (x >1 && x <100) || (x<0) );
		System.out.println(result);

		x = 100;
		result = ( (x >1 && x <100) || (x<0) );
		System.out.println(result);
		
		x = 101;
		result = ( (x >1 && x <100) || (x<0) );
		System.out.println(result);

		

	}

}
