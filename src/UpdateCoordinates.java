package src;

import java.awt.*;

public class UpdateCoordinates {
    Point volvoPoint = new Point();
    Point saabPoint = new Point();
    Point scaniaPoint = new Point();


    void moveit(int x, int y, String modelName){
        if(modelName.equals("Volvo240")) {
            volvoPoint.x = x;
            volvoPoint.y = y;
        }
        else if(modelName.equals("Saab95")){
            saabPoint.x = x;
            saabPoint.y = y;
        }
        else if(modelName.equals("Scania")){
            scaniaPoint.x = x;
            scaniaPoint.y = y;
        }
    }
}
