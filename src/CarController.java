package src;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;


/*
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController{
    CarView frame;
    World world;
    ButtonMethods methods;
    private int gasAmount = 0;
    private int angleAmount = 0;

    public CarController(CarView frame, ButtonMethods methods)  {
        this.frame = frame;
        this.methods = methods;
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
                methods.gas(gasAmount);
            }
        });

        frame.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                methods.brake(gasAmount);
            }
        });

        frame.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                methods.turboOn();
            }
        });

        frame.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                methods.turboOff();
            }
        });

        frame.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                methods.liftBed(angleAmount);
            }
        });

        frame.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                methods.lowerBed(angleAmount);
            }
        });

        frame.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                methods.start();
            }
        });

        frame.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                methods.stop();
            }
        });

        frame.addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                methods.addCar();
            }
        });

        frame.removeCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                methods.removeCar();
            }
        });

}
}


