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
    }


public ArrayList<Car> getTheCars(){
    cars.add(new Volvo240());
    cars.add(new Saab95());
    cars.add(new Scania());
        return cars;}


    public void createSpinners(){
    SpinnerModel spinnerModel =
            new SpinnerNumberModel(0, //initial value
                    0, //min
                    100, //max
                    1);//step
    gasSpinner = new JSpinner(spinnerModel);

    SpinnerModel spinnerModelAngle =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        70, //max
                        1);//step
        angleSpinner = new JSpinner(spinnerModelAngle);
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
