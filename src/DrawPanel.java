package src;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    //UpdateCoordinates updateC;

    Volvo240 volvo;
    Saab95 saab;
    Scania scania;

    CarController carC;



    ArrayList<BufferedImage> carImage = new ArrayList<>();


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {


        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        //updateC = new UpdateCoordinates();
        // Print an error message in case file is not found with a try/catch block
        try {
            carImage.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            carImage.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
            carImage.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
            g.drawImage(carImage.get(0), volvo.getXcoord(), volvo.getYcoord(), null); // see javadoc for more info on the parameters
            g.drawImage(carImage.get(1), saab.getXcoord(), saab.getYcoord(), null); // see javadoc for more info on the parameters
            g.drawImage(carImage.get(2), scania.getXcoord(), scania.getYcoord(), null); // see javadoc for more info on the parameters
    }
}
