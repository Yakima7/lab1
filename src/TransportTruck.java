package src;

import java.awt.*;
import java.util.*;

public class TransportTruck extends Truck{

    int MaximumLoad;

    public TransportTruck(){
        super(2, 250, Color.white,
                "src.TransportTruck", 3);
        MaximumLoad=5;

    }


    ArrayList<Car> CarsOnTruck = new ArrayList<Car>();

    public ArrayList<Car> getArrayList(){return CarsOnTruck;}


    public double speedFactor() {
        return getEnginePower() * 0.005;
    }

    public void angleUp(){
        changeAngleUp(70);
    }

    public void angleDown(){
        changeAngleDown(70);
    }


    public void LoadTruck(Car carToBeLoaded){
        double carXCoord = carToBeLoaded.getXcoord();
        double TransportTruckXCoord = this.getXcoord();
        double carYCoord = carToBeLoaded.getYcoord();
        double TransportTruckYCoord = this.getYcoord();
        double TheSizeOfCar=carToBeLoaded.getSize();
        if (carToBeLoaded instanceof TransportTruck || TheSizeOfCar > 2){
        }
        else if (currentAngle == 0 && Math.abs(carXCoord - TransportTruckXCoord) <= 2
                && Math.abs(carYCoord-TransportTruckYCoord) <= 2 &&
                CarsOnTruck.size() < MaximumLoad){
            CarsOnTruck.add(carToBeLoaded);
        }

    }


    //public boolean EmptySpotCheck(){


    //}

    public void UnloadTruck(Car carToBeUnloaded){
        Car LastCar = CarsOnTruck.get(CarsOnTruck.size()-1);
        if (currentAngle==0 && LastCar==carToBeUnloaded){
            for(int i=CarsOnTruck.size()-1; i>=0; i--) {
                CarsOnTruck.remove(CarsOnTruck.size()-1);

            }

        }
    }

    @Override public void move(){
        super.move();
        for (Car car : CarsOnTruck) {
            car.setXcoord(this.getXcoord());
            car.setYcoord(this.getYcoord());
    }


    }
}
