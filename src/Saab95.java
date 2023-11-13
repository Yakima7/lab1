package src;

import src.cars;

import java.awt.*;

public class Saab95 extends cars {

    private boolean turboOn;

    public Saab95() {
       super(2,125,0, Color.red,
               "scr.Saab95", compass.North,0,0);
    turboOn = false;
 //modelName = "src.Saab95";

    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }


    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

}
