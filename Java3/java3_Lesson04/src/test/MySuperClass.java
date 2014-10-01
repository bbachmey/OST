package test;

public class MySuperClass {
	
	int i;

	public static void main(String[] args) {
		MySuperClass c1 = new MySuperClass();
		System.out.println("Value of c1 is " + c1.i);
		MySuperClass c2 = new MySuperClass(12);
		System.out.println("Value of c2 is " + c2.i);
		
	}
	
	public MySuperClass(){
		i=10;
		
	}
	
	public MySuperClass(int value){
		this.i = value;
		
	}

}
