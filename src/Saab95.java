package src;

import src.cars;

import java.awt.*;

public class Saab95 extends cars {

    private boolean turboOn;

    public Saab95() {
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        turboOn = false;
        modelName = "src.Saab95";
        stopEngine();
        direction = compass.North;
        xcoord = 0;
        ycoord = 0;
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
