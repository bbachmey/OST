package test;

public class MySubClass extends MySuperClass {
	
	public MySubClass(){
    } 

    public MySubClass(int x){

        super(x);  // passes the desired value to the super. 
        System.out.println("Here I am passing " + x + " to my super for a value of i");
    	
    }
	
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
