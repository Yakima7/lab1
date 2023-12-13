package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main{

    public static void main(String[] args) {
        World world = new World();
        DrawPanel drawPanel = new DrawPanel();
        world.addCarListObserver(drawPanel);
        //world.addCarListObserver(world.timer);
        CarController cc = new CarController(world);
        CarView frame = new CarView("CarSim 1.0", cc, drawPanel);
        world.addPaintObserver(frame);

        // Instance of this class
        // Start a new view and send a reference of self
        world.timer.start();
    }

}

