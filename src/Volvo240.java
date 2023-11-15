package src;

import java.awt.*;

public class Volvo240 extends cars {

    private final static double trimFactor = 1.25;
    
    public Volvo240(){
        super(4, 100, Color.black,
                "src.Volvo240");

    }

    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

}
