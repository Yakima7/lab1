package src;

import src.cars;

import java.awt.*;

public class Volvo240 extends cars {

    private final static double trimFactor = 1.25;
    
    public Volvo240(){
        super(4, 100, 0, Color.black,
                "src.Volvo240", compass.North, 0, 0);

    }

    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

}
