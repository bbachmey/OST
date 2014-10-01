package test;

public class MySubClass extends MySuperClass {
	
	public static void main(String[] args){
		
		MySubClass testing = new MySubClass();
		System.out.println("From MySubClass, the value of testing.i is " + testing.i);
		//System.out.println("Notice how this will not work " + testing.super.i);
		
	}

}
