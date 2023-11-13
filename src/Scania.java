*package src;
import src.cars;
import java.awt.*;

public class Scania{


    public double currentAngle;

    public Scania(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 250;
        currentAngle = 0;
        modelName = "src.Scania";
    }

    public double getCurrentAngle(){
        return currentAngle;
    }

    public void ChangeAngleUp(double numb){
        if (currentSpeed == 0){
        currentAngle= Math.min(getCurrentAngle() + numb,70);}

    }

    public void ChangeAngleDown(double numb){
        if (currentSpeed == 0){
        currentAngle= Math.max(getCurrentAngle() - numb,0);}
    }

    public double speedFactor(){
        return enginePower * 0.005;
    }
}
