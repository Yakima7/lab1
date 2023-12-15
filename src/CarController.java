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

public class CarController{
    CarView frame;
    World world;
    //private int gasAmount = 0;
    //private int angleAmount = 0;

    //private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern

    public CarController(CarView frame)  {
        this.frame = frame;
        actionListeners();

    }


    public void actionListeners() {
        frame.gasButton.addActionListener(frame.createGasButtonListener());

        frame.brakeButton.addActionListener(frame.createBrakeButtonListener());

        frame.turboOnButton.addActionListener(frame.createTurboOnButtonListener());

        frame.turboOffButton.addActionListener(frame.createTurboOffButtonListener());

        frame.liftBedButton.addActionListener(frame.createLiftBedButtonListener());

        frame.lowerBedButton.addActionListener(frame.createLowerBedButtonListener());

        frame.startButton.addActionListener(frame.createStartButtonListener());

        frame.stopButton.addActionListener(frame.createStopButtonListener());

        frame.gasSpinner.addChangeListener(frame.createGasSpinnerListener());

        frame.angleSpinner.addChangeListener(frame.createAngleSpinnerListener());
    }


}


