package src;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {


    // member fields:

    Volvo240 volvo240 = new Volvo240();
    Saab95 saab95 = new Saab95();
    Scania scania = new Scania();
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();


        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                //int xCoord=car.getXcoord();
                int yCoord=car.getYcoord();
                if ( yCoord<0 || yCoord>500){
                    car.turnAround();}
                car.move();
                int x = (int) Math.round(car.getXcoord());
                int y = (int) Math.round(car.getYcoord());
                frame.drawPanel.moveit(x, y, car.getModelName());
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount)/100;
        for (Car car : cars){
            car.brake(brake);
        }
    }

    void turboOn(Saab95 car){
        saab95.setTurboOn();
    }

    void turboOff(){
        saab95.setTurboOff();
    }

    void liftBed(int angle){
        Scania scania = (Scania) cars.get(2);
        scania.changeAngleUp(angle);
    }

    void lowerBed(Scania car, int angle){
        car.changeAngleDown(angle);
    }

    void start(){
        for (Car car : cars){
            car.startEngine();
        }
    }
    void stop(){
        for (Car car : cars){
            car.stopEngine();
        }
    }
}
