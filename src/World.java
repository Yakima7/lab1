package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class World {
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;

    CarView frame;
    DrawPanel drawPanel;

    ArrayList<Car> cars = new ArrayList<>();

    public World(/*CarView frame, DrawPanel drawPanel*/){
        //this.frame = frame;
        //this.drawPanel = drawPanel;
        cars.add(new Volvo240());
        cars.add(new Saab95());
        cars.add(new Scania());
    }

    public ArrayList<Car> getCars(){
        return cars;
    }

    private ArrayList<CarListObserver> carListeners = new ArrayList<>();

    public void addCarListObserver(CarListObserver carListener) {
        this.carListeners.add(carListener);
    }

    public void removeCarListObserver(CarListObserver carListener) {
        this.carListeners.remove(carListener);
    }

    public void notifyCarListObservers() {
        for (CarListObserver listener : this.carListeners) {
            listener.update(this.cars);
        }
    }

    private ArrayList<PaintObserver> paintListeners = new ArrayList<>();

    public void addPaintObserver(PaintObserver paintListener) {
        this.paintListeners.add(paintListener);
    }

    public void removePaintObserver(PaintObserver paintListener) {
        this.paintListeners.remove(paintListener);
    }

    public void notifyPaintObservers() {
        for (PaintObserver paintListener : this.paintListeners) {
            paintListener.updatePaint();
        }
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

    public class TimerListener implements ActionListener{
        //private ArrayList<Car> cars;
/*
        public TimerListener() {

        }
        @Override
        public void update(ArrayList<Car> cars) {
            this.cars = cars;
        }
*/
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
                notifyPaintObservers();
            }
        }
    }

//TODO:preleminär add och remove car metoder
    /*void addCar(){
    if(cars.size()<10){
    Arraylist<Car>typesOfCar = new Arraylist<>();
    typesOfCar.add("Volvo240");
    typesOfCar.add("Saab95");
    typesOfCar.add("Scania");
    nrOfCars=cars.size();
    int indexNr = nextInt(nrOfCars);
    String modelToBeAdded = typesOfCar.get(indexNr); Slumpa fram en bil model

    lastCar=cars.get(cars.size() - 1);
    x=lastCar.getXCoord();
    if(x<340*//* preliminärt*//*);{
    x+=100;} *//*Ta fram koordinater från bil längst ned+100*//*
    else if(x>=340);{x=0}*//* Loopar inlägningen*//*

    cars.add(modelToBeAdded);
    newCar=cars.get(cars.size() - 1);
    newCar.setXCoord(x); Lägg till bilen och sätt dess koordinter
    //TODO: updatera grafiken, hur grafiken är uppbyggd måste vetas först då
    }}

    void removeCar(){
    if(cars.size()!=0){
    indexNr=cars.get(cars.size() - 1);
    cars.remove(indexNr);
    //TODO: updatera grafiken, hur grafiken är uppbyggd måste vetas först då
    }}*/


    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */


}
