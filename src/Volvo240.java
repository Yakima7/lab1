package src;

import src.cars;

import java.awt.*;

public class Volvo240 extends cars {

    private final static double trimFactor = 1.25;
    
    public Volvo240(){
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "src.Volvo240";
        stopEngine();
        direction = compass.North;
        xcoord = 0;
        ycoord = 0;
    }

    //ändrade klassen till public för att kunna använda den i testerna
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

}
