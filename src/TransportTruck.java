package src;

import java.awt.*;
import java.util.*;

public class TransportTruck extends Truck{
    public TransportTruck(){
        super(2, 250, Color.white,
                "src.TransportTruck");
    }


    ArrayList<Car> CarsOnTruck = new ArrayList<Car>();


    public double speedFactor() {
        return getEnginePower() * 0.005;
    }


    public void LoadTruck(Car carToBeLoaded){
        double carXCoord = carToBeLoaded.getXcoord();
        double TransportTruckXCoord = this.getXcoord();
        if (currentAngle==0 && Math.abs(carXCoord-TransportTruckXCoord <= 2) && ){
            CarsOnTruck.add(carToBeLoaded);


        }
    }


    public void UnloadTruck(Car carToBeUnloaded){
        Car LastCar = CarsOnTruck.get(CarsOnTruck.size()-1);
        if (currentAngle==0 && LastCar==carToBeUnloaded){

        }
    }
}
