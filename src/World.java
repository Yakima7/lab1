package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class World {
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;

    CarController cc;
    CarView frame;

    //ArrayList<Car> theCars = CarController.getTheCars(); //test men problem

    public Timer timer = new Timer(delay, new TimerListener());

    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cc.cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount)/100;
        for (Car car : cc.cars){
            car.brake(brake);
        }
    }

    void turboOn(){
        Saab95 saab = (Saab95) cc.cars.get(1);
        saab.setTurboOn();
    }

    void turboOff(){
        Saab95 saab = (Saab95) cc.cars.get(1);
        saab.setTurboOff();
    }

    void liftBed(int angle){
        Scania scania = (Scania) cc.cars.get(2);
        scania.changeAngleUp(angle);
    }

    void lowerBed(int angle){
        Scania scania = (Scania) cc.cars.get(2);
        scania.changeAngleDown(angle);
    }

    void start(){
        for (Car car : cc.cars){
            car.startEngine();
        }
    }
    void stop(){
        for (Car car : cc.cars){
            car.stopEngine();
        }
    }
    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */

    public class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cc.cars) {
                int xCoord = car.getXcoord();
                int yCoord = car.getYcoord();
                if (yCoord < 0 || yCoord > 500 || xCoord < 0 || xCoord > 700) {
                    car.turnAround();
                }
                car.move();
                int x = (int) Math.round(car.getXcoord());
                int y = (int) Math.round(car.getYcoord());
                car.setXcoord(x);
                car.setYcoord(y);
                //updateC.moveit(x, y, car.getModelName());
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }
}
