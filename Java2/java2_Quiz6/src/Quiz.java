
public class Quiz {

	public static void main(String[] args) {

		//What are the results of the following integer operations? 
		//a.3 + 5 %3 
		//b.(3 + 5) % 3 
		//c.3 / 2 + 5 / 2 
		//d.8 - 4 * 2 
		//e.14 + 1 / 2 * 4 

		System.out.println(3 + 5 %3);
		System.out.println((3 + 5) % 3);
		System.out.println(3 / 2 + 5 / 2);
		System.out.println(8 - 4 * 2);
		System.out.println(14 + 1 / 2 * 4);

		//Given x=4, y=6, z=2, evaluate the expressions: 
		//a.x + y * z * z 
		//b.x + ((y * z) * z) 
		//c.(x + y) * (z * z) 

		System.out.println( 4+6*2*2 );
		System.out.println( 4+((6*2)*2) );
		System.out.println( (4+6)*(2*2) );
		
		//Given the following values: 
		//int i = 3, j = 4;
		//double x = 12.4;
		//What are the results of the following operations? 
		//a.-i * -j * (int)(x) 
		//b.i / 4 * x 
		//c.14 + 1.0 / 2 * j 

		int i = 3, j = 4;
		double x = 12.4;
		
		System.out.println(-i * -j * (int)(x) );
		System.out.println(i / 4 * x );
		System.out.println(14 + 1.0 / 2 * j );
				
		System.out.println();

	}

}
