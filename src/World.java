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

    public ArrayList<Car> getList(){
        return cars;
    }
    public void updateCarList(ArrayList<Car> carList){
        this.cars = carList;
    }


    //PaintObserver
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
