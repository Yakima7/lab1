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

    // The controller member
    private final CarController carC;

    private final DrawPanel drawPanel;

    private final JPanel controlPanel = new JPanel();

    private final JPanel gasPanel = new JPanel();

    private final JPanel anglePanel = new JPanel();

    private final JSpinner gasSpinner = new JSpinner();

    private final JSpinner angleSpinner = new JSpinner();

    private final JLabel gasLabel = new JLabel("Gas");

    private final JLabel angleLabel = new JLabel("Angle");



    private final JButton gasButton = new JButton("Gas");
    private final JButton brakeButton = new JButton("Brake");
    private final JButton turboOnButton = new JButton("Saab Turbo on");
    private final JButton turboOffButton = new JButton("Saab Turbo off");
    private final JButton liftBedButton = new JButton("Scania Lift Bed");
    private final JButton lowerBedButton = new JButton("Lower Lift Bed");

    private final JButton startButton = new JButton("Start all cars");
    private final JButton stopButton = new JButton("Stop all cars");

    // Constructor
    public CarView(String framename, CarController cc, DrawPanel drawPanel){
        this.drawPanel = drawPanel;
        this.carC = cc;
        initComponents(framename);
    }
    @Override
    public void updatePaint(){
        drawPanel.repaint();
    }

    // Sets everything in place and fits everything
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(drawPanel.getX(), drawPanel.getY()));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        gasSpinner.addChangeListener(carC.createGasSpinnerListener());
        angleSpinner.addChangeListener(carC.createAngleSpinnerListener());

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        anglePanel.setLayout(new BorderLayout());
        anglePanel.add(angleLabel, BorderLayout.PAGE_START);
        anglePanel.add(angleSpinner, BorderLayout.PAGE_END);

        this.add(anglePanel);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((drawPanel.getX()/2), 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(drawPanel.getX()/5-15,200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(drawPanel.getX()/5-15,200));
        this.add(stopButton);

        gasButton.addActionListener(carC.createGasButtonListener());

        brakeButton.addActionListener(carC.createBrakeButtonListener());

        turboOnButton.addActionListener(carC.createTurboOnButtonListener());

        turboOffButton.addActionListener(carC.createTurboOffButtonListener());

        liftBedButton.addActionListener(carC.createLiftBedButtonListener());

        lowerBedButton.addActionListener(carC.createLowerBedButtonListener());

        startButton.addActionListener(carC.createStartButtonListener());
        
        stopButton.addActionListener(carC.createStopButtonListener());

        // Make the frame pack all it's components by respecting the sizes if possible.
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