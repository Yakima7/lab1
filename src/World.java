package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class   World {
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    CarFactory carFactory;
    ArrayList<Car> cars = new ArrayList<>();

    public World(CarFactory carFactory){
        this.carFactory = carFactory;
        cars.add(new Volvo240());
        cars.add(new Saab95());
        cars.add(new Scania());
    }

    

    //Observers
    //CarListObserver
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
    //RemoveCarObserver
    private ArrayList<RemoveCarObserver> removeCarListener = new ArrayList<>();

    public void addRemoveCarObserver(RemoveCarObserver removeCarListener){
        this.removeCarListener.add(removeCarListener);
    }

    public void removeRemoveCarObserver(RemoveCarObserver removeCarListener){
        this.removeCarListener.remove(removeCarListener);
    }

    public void notifyRemoveCarObservers(ArrayList<Car>cars){
        for (RemoveCarObserver listener : this.removeCarListener) {
            listener.removeCar(cars);
        }
    }
    //PaintObservers
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

    void addCar() {
        if (cars.size() < 10) {
            Car newCar = carFactory.createCar();
            cars.add(newCar);
            notifyCarListObservers();
        }
    }

    void removeCar() {
        if (!cars.isEmpty()) {
            notifyRemoveCarObservers(cars);
            cars.remove(cars.getLast());
            notifyPaintObservers();
        }
    }
    public Timer timer = new Timer(delay, new TimerListener());

    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    public class TimerListener implements ActionListener{
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

}
