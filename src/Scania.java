package src;
import src.Car;
import src.Truck;

import java.awt.*;

public class Scania extends Truck {

    public Scania(){
        super(2,250, Color.red,
                "src.Scania", 2);
    }


    public double speedFactor(){
        return getEnginePower() * 0.005;
    }
}
