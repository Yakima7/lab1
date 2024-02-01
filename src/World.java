package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class   World {
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;

    ArrayList<Car> cars = new ArrayList<>();

    public World(){
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

    public Timer timer = new Timer(delay, new TimerListener());

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
