package test;

public class MySuperClass {
	
	int i, otherVariable;
	
//	public static void main(String[] args) {
//		MySuperClass c1 = new MySuperClass();
//		System.out.println("Value of c1 is " + c1.i);
//		MySuperClass c2 = new MySuperClass(12);
//		System.out.println("Value of c2 is " + c2.i);
//		
//	}
	
	public MySuperClass(){
		//this.i=10;
		this(10);
		System.out.println("\nMySuperClass(): the default value is " + 10); 
		
	}
	
	public MySuperClass(int value){
		this(value, 42);
        System.out.println("\nMySuperClass(int value): value is " + value + " with a new default of 42");
		
	}
	
    public MySuperClass(int value, int value2){
        this.i = value; 
        this.otherVariable = value2;
        System.out.println("\nMySuperClass(int value, int value2): Something I inherit from Object: " + this.toString());
        System.out.println("  i is " + i + " and otherVariable is " +otherVariable);
    }
    
}
