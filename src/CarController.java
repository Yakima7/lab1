package src;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {

    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;

    ArrayList<Car> cars = new ArrayList<>();

    public CarController(CarView frame){
        cars.add(new Volvo240());
        cars.add(new Saab95());
        cars.add(new Scania());
        timer.start();
        this.frame = frame;
        frame.add(actionlistener);
    }




    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                int xCoord=car.getXcoord();
                int yCoord=car.getYcoord();
                if ( yCoord<0 || yCoord>500 || xCoord<0 || xCoord>700 ){
                    car.turnAround();}
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

    ChangeListener createGasSpinnerListener(){

    }
    ActionListener createGasButtonListener(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                World.gas(gasAmount);
            }
        };
    }

}
