package test;

public class MySubClass extends MySuperClass {
	
	//int i = 42;
	
	public static void main(String[] args){
		
		MySubClass testing = new MySubClass();

		testing.addToI(6);
		
	}


    public void addToI (int j) {
    	
    	super.addToI (j);
        i = i + (j / 2);
        System.out.println("After MySubClass addToI, i is " + i); 
    
    }


}
