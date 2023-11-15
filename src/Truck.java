package src;

import java.awt.*;

public abstract class Truck extends Car{

    public Truck(int nrDoors, double enginePower, Color color,
                 String modelName){
        super(nrDoors, enginePower, color, modelName);
        this.currentAngle=0;
    }

    public double currentAngle;

    public double getCurrentAngle(){
        return currentAngle;
    }


    public void ChangeAngleUp(double numb){
        if (getCurrentSpeed() == 0){
            currentAngle= Math.min(getCurrentAngle() + numb,70);}

    }

    public void ChangeAngleDown(double numb){
        if (getCurrentSpeed() == 0){
            currentAngle= Math.max(getCurrentAngle() - numb,0);}
    }


    @Override public void move(){
        if (0 == currentAngle){
            super.move();
        }
    }
}
