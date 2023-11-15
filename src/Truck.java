package src;

import java.awt.*;

public abstract class Truck extends Car{

    public Truck(int nrDoors, double enginePower, Color color,
                 String modelName, int size){
        super(nrDoors, enginePower, color, modelName, size);
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
        if (currentAngle == 0){
            super.move();
        }
    }
}
