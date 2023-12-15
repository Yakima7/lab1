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
    private int gasAmount = 0;
    private int angleAmount = 0;

    //private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern

    public CarController(CarView frame, World world)  {
        this.frame = frame;
        this.world = world;
        actionListeners();

    }

    public void actionListeners() {
        frame.gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });
        frame.angleSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent a) {
                angleAmount = (int) ((JSpinner) a.getSource()).getValue();
            }
        });

        frame.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                world.gas(gasAmount);
            }
        });

        frame.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                world.brake(gasAmount);
            }
        });

        frame.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                world.turboOn();
            }
        });

        frame.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                world.turboOff();
            }
        });

        frame.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                world.liftBed(angleAmount);
            }
        });

        frame.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                world.lowerBed(angleAmount);
            }
        });

        frame.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                world.start();
            }
        });
        frame.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                world.stop();
            }
        });


        frame.addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                world.addCar();
            }
        });

        frame.removeCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                world.removeCar();
            }
        });



    }
/*

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

 */
}


