package src;

import java.awt.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;
    
    public Volvo240(){
        super(4, 100, Color.black,
                "Volvo240", 1, 0, 100);

    }

    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

}
