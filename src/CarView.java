package src;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of its components.
 **/

public class CarView extends JFrame implements PaintObserver{
    //Creating variables and buttons
    DrawPanel drawPanel;
    World world;
    JPanel controlPanel = new JPanel();
    JPanel gasPanel = new JPanel();
    JPanel anglePanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    JSpinner angleSpinner = new JSpinner();
    JLabel gasLabel = new JLabel("Gas");
    JLabel angleLabel = new JLabel("Angle");
    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");
    //private int gasAmount = 0;
    //private int angleAmount = 0;
    // Constructor
    public CarView(String framename, DrawPanel drawPanel, World world){
        this.drawPanel = drawPanel;
        this.world = world;
        //this.carC = cc;
        initComponents(framename);
    }
    @Override
    public void updatePaint(){
        //drawPanel.repaint();
        drawPanel.paintComponent(drawPanel.getGraphics());
    }

    // Sets everything in place and fits everything
     void initComponents(String title) {

         this.setTitle(title);
         this.setPreferredSize(new Dimension(drawPanel.getX(), drawPanel.getY()));
         this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

         this.add(drawPanel);

         gasPanel.setLayout(new BorderLayout());
         gasPanel.add(gasLabel, BorderLayout.PAGE_START);
         gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

         anglePanel.setLayout(new BorderLayout());
         anglePanel.add(angleLabel, BorderLayout.PAGE_START);
         anglePanel.add(angleSpinner, BorderLayout.PAGE_END);

         this.add(anglePanel);
         this.add(gasPanel);

         controlPanel.setLayout(new GridLayout(2, 4));
         controlPanel.add(gasButton, 0);
         controlPanel.add(turboOnButton, 1);
         controlPanel.add(liftBedButton, 2);
         controlPanel.add(brakeButton, 3);
         controlPanel.add(turboOffButton, 4);
         controlPanel.add(lowerBedButton, 5);
         controlPanel.setPreferredSize(new Dimension((drawPanel.getX() / 2), 200));
         this.add(controlPanel);
         controlPanel.setBackground(Color.CYAN);
         startButton.setBackground(Color.blue);
         startButton.setForeground(Color.green);
         startButton.setPreferredSize(new Dimension(drawPanel.getX() / 5 - 15, 200));
         this.add(startButton);
         stopButton.setBackground(Color.red);
         stopButton.setForeground(Color.black);
         stopButton.setPreferredSize(new Dimension(drawPanel.getX() / 5 - 15, 200));
         this.add(stopButton);

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

         this.pack();

         // Get the computer screen resolution
         Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
         // Center the frame
         this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
         // Make the frame visible
         this.setVisible(true);
         // Make sure the frame exits when "x" is pressed
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
/*
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
                //world.gas(gasAmount);
                System.out.println(gasAmount);
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
        // Make the frame pack all it's components by respecting the sizes if possible.
*/
}