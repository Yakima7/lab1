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
    CarView frame;




    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    //private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern


    public CarController(CarView frame) {
        this.frame = frame;
    }


//public ArrayList<Car> getTheCars(){return cars;}



        frame.gasButton.addActionListener(createGasButtonListener());

        brakeButton.addActionListener(createBrakeButtonListener());

        turboOnButton.addActionListener(createTurboOnButtonListener());

        turboOffButton.addActionListener(createTurboOffButtonListener());

        liftBedButton.addActionListener(createLiftBedButtonListener());

        lowerBedButton.addActionListener(createLowerBedButtonListener());

        startButton.addActionListener(createStartButtonListener());

        stopButton.addActionListener(createStopButtonListener());
}


