package src;

import java.awt.*;

public class Scania extends Car {

    public Scania () {
        super(2,250, Color.red,
                "src.Scania", 2);
        this.currentAngle = 0;
    }

    public double currentAngle;

    public double getCurrentAngle(){
        return currentAngle;
    }


    public void changeAngleUp(double numb){
        if (getCurrentSpeed() == 0){
            currentAngle = Math.min(getCurrentAngle() + numb,70);}

    }

    public void changeAngleDown(double numb){
        if (getCurrentSpeed() == 0){
            currentAngle = Math.max(getCurrentAngle() - numb,0);}
    }


    @Override public void move(){
        if (currentAngle == 0){
            super.move();
        }
    }


    public double speedFactor(){
        return getEnginePower() * 0.005;
    }
}
