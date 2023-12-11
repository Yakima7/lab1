package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class World {
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;

    CarView frame;

    ArrayList<Car> cars = new ArrayList<>();

    public World(){
        cars.add(new Volvo240());
        cars.add(new Saab95());
        cars.add(new Scania());
    }

    public ArrayList<Car> getCars(){
        return cars;
    }


    //ArrayList<Car> theCars = CarController.getTheCars(); //test men problem
    //ArrayList<Car> theCars = Main.getCarController();

    public Timer timer = new Timer(delay, new TimerListener());

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

    void turboOn() {
        for (Car car : cars) {
            if(car.getModelName().equals("Saab95")){
            Saab95 saab = (Saab95) car;
                saab.setTurboOn();
            }
        }
    }

    void turboOff(){
        Saab95 saab = (Saab95) cars.get(1);
        saab.setTurboOff();
    }

    void liftBed(int angle){
        Scania scania = (Scania) cars.get(2);
        scania.changeAngleUp(angle);
    }

    void lowerBed(int angle){
        Scania scania = (Scania) cars.get(2);
        scania.changeAngleDown(angle);
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


//TODO:preleminär add och remove car metoder
    /*void addCar(){
    Arraylist<Car>typesOfCar = new Arraylist<>();
    typesOfCar.add("Volvo240");
    typesOfCar.add("Saab95");
    typesOfCar.add("Scania");
    nrOfCars=cars.size();
    int indexNr = nextInt(nrOfCars);
    String modelToBeAdded = typesOfCar.get(indexNr); Slumpa fram en bil model

    lastCar=cars.get(cars.size() - 1);
    x=lastCar.getXCoord();
    x+=100; Ta fram koordinater från bil längst ned+100

    cars.add(modelToBeAdded);
    newCar=cars.get(cars.size() - 1);
    newCar.setXCoord(x); Lägg till bilen och sätt dess koordinter
    }

    void removeCar(){
    indexNr=cars.get(cars.size() - 1);
    cars.remove(indexNr);
    //TODO: updatera grafiken, hur grafiken är uppbyggd måste vetas först då
    }}*/


    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */

    public class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
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
