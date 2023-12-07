package src;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.event.ChangeEvent;


/*
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {

    int gasAmount = 0;
    JSpinner gasSpinner = new JSpinner();

    int angleAmount = 0;
    JSpinner angleSpinner = new JSpinner();



    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    //private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    World world;

    //ArrayList<Car> cars = new ArrayList<>();

/*
    public CarController() {
        cars.add(new Volvo240());
        cars.add(new Saab95());
        cars.add(new Scania());
    }
*/

//public ArrayList<Car> getTheCars(){return cars;}


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

    ChangeListener createGasSpinnerListener() {
        return new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        };
    }

    ChangeListener createAngleSpinnerListener() {
        return new ChangeListener() {
            public void stateChanged(ChangeEvent a) {
                angleAmount = (int) ((JSpinner) a.getSource()).getValue();
            }
        };
    }

    ActionListener createGasButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                world.gas(gasAmount);
            }
        };
    }

    ActionListener createBrakeButtonListener(){
        return new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){world.brake(gasAmount);}
        };
    }

    ActionListener createTurboOnButtonListener(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {world.turboOn();}
            };
        }

        ActionListener createTurboOffButtonListener(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {world.turboOff();}
            };
        }

        ActionListener createLiftBedButtonListener(){
                return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {world.liftBed(angleAmount);}
            };
        }

        ActionListener createLowerBedButtonListener(){
    return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                world.lowerBed(angleAmount);}
            };
        }

        ActionListener createStartButtonListener(){
    return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {world.start();}
            };
        }

        ActionListener createStopButtonListener(){
    return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {world.stop();}
            };
        }
}


