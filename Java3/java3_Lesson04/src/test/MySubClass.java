package test;

public class MySubClass extends MySuperClass {
	
	int i = 42;
	
	public static void main(String[] args){
		
		MySubClass testing = new MySubClass();
		//System.out.println("From MySubClass, the value of testing.i is " + testing.i);
		
		testing.whatsHere();
		
		//System.out.println("Notice how this will not work " + testing.super.i);
	    
	}

    public void whatsHere() {
        System.out.println("From MySubClass, this.i is " + this.i + " and i is " + i);
        System.out.println(" shadowing MySuperClass's value (super.i): " + super.i);
    }

}
