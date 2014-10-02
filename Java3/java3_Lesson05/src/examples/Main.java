package examples;

public class Main {
	
    public static void main(String [] args){
        Dog myDog = new Dog("female");
        System.out.println("I am domesticated: " + myDog.isDomesticated());
        myDog.feedYoung();   // inherit from super
        if (myDog.gender == "male")
    	    System.out.print("My offspring come: ");
        else
    	    System.out.print("I give birth: ");
        myDog.liveBirth();   // implemented abstract method of super
    }  
}