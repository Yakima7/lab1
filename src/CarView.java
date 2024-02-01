package src;
import javax.swing.*;
import java.awt.*;



/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching its controller in its state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of its components.
 **/

public class CarView extends JFrame {
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
    JButton turboOnButton = new JButton("Turbo on Saab");
    JButton turboOffButton = new JButton("Turbo off Saab");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");
    JButton addCarButton = new JButton("Add car");
    JButton removeCarButton = new JButton("Remove car");


    public CarView(String framename, DrawPanel drawPanel){
        this.drawPanel = drawPanel;
        this.world = world;
        initComponents(framename);
    }

    // Sets everything in place and fits everything
     void initComponents(String title) {

         this.setTitle(title);
         this.setPreferredSize(new Dimension(drawPanel.getX(), drawPanel.getY()));
         this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

         this.add(drawPanel);

         this.add(anglePanel);
         this.add(gasPanel);

         controlPanel.setLayout(new GridLayout(2, 4));
         controlPanel.add(gasButton, 0);
         controlPanel.add(turboOnButton, 1);
         controlPanel.add(liftBedButton, 2);
         controlPanel.add(addCarButton, 3);
         controlPanel.add(brakeButton, 4);
         controlPanel.add(turboOffButton, 5);
         controlPanel.add(lowerBedButton, 6);
         controlPanel.add(removeCarButton, 7);
         controlPanel.setPreferredSize(new Dimension((drawPanel.getX() / 2 + 55), 200));
         this.add(controlPanel);
         controlPanel.setBackground(Color.CYAN);
         startButton.setBackground(Color.blue);
         startButton.setForeground(Color.green);
         startButton.setPreferredSize(new Dimension(drawPanel.getX() / 5 - 40, 200));
         this.add(startButton);
         stopButton.setBackground(Color.red);
         stopButton.setForeground(Color.black);
         stopButton.setPreferredSize(new Dimension(drawPanel.getX() / 5 - 40, 200));
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
         gasPanel.setLayout(new BorderLayout());
         gasPanel.add(gasLabel, BorderLayout.PAGE_START);
         gasPanel.add(gasSpinner, BorderLayout.PAGE_END);


         anglePanel.setLayout(new BorderLayout());
         anglePanel.add(angleLabel, BorderLayout.PAGE_START);
         anglePanel.add(angleSpinner, BorderLayout.PAGE_END);
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

}