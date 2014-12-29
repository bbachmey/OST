package collections;

public class Cheetah extends Mammal {
    private double runningSpeed = 70.00;     // in mph
    private double height = 1.25;  // shoulder height in meters 

    public Cheetah(String who){
        super(who);
    }
	
    public double getHeight(){
        return height;
    }

    public double getSpeed(){
       return runningSpeed;
    }
}