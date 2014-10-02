package examples;

public abstract class Mammal {
    boolean hasHair = true;
    String breathes = "oxygen";
    String skeletalStructure = "backbone";
    String gender;

    public Mammal(String sex){
        gender = sex;
        System.out.println("I am a " + gender + " dog");
    }

    // Depending on hierarchy, you might have this abstract method in "animal"
    // Since we show inheritance from Object, we are safe here.  
    // Mammals move differently, so this is a differentiation (some 2 legs, some 4)
    public abstract void move();  

    // all mammals give birth to live young, but the methods may be different.
    // Shhh, we know about the platypus. Do you want to type more?
    public abstract void liveBirth();  

    public void feedYoung(){  // this one is specific to mammals
        String food = "milk";
        System.out.println("Since I am " + gender + ", ");
        if (gender =="female")
            System.out.println("I provide my young with " + food);
            // the content of the method could say how 
            // depending on your level of specificity, this could be abstract too
        else
            System.out.println("I need assistance to feed my young " + food);
    }

    public boolean hasMammaryGlands(){
        return true;
    }

    public abstract void eat();
}