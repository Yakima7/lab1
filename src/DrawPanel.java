package src;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

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
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void pairCarWithPic() {
        for (Car car : world.getCars()) {
            if (car.getModelName().equals("Volvo240")) {
                carPic.put(car, carImage.get(0));
            } else if (car.getModelName().equals("Saab95")) {
                carPic.put(car, carImage.get(1));
            } else if (car.getModelName().equals("Scania")) {
                carPic.put(car, carImage.get(2));
            }
        }
    }


    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (BufferedImage pic : carPic.values()) {
            for (Car car : carPic.keySet()) {
                g.drawImage(pic, car.getXcoord(), car.getYcoord(), null);
            }
            /*g.drawImage(carImage.get(0), getXcoord(), getYcoord(), null); // see javadoc for more info on the parameters
            g.drawImage(carImage.get(1), getXcoord(), getYcoord(), null); // see javadoc for more info on the parameters
            g.drawImage(carImage.get(2), getXcoord(), getYcoord(), null); // see javadoc for more info on the parameters*/
        }
    }
}
