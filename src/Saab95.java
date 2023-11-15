package src;

import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;

    public Saab95() {
       super(2,125, Color.red,
               "scr.Saab95");
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

        return getEnginePower() * 0.01 * turbo;
    }

}
