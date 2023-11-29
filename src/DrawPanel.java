package src;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{


    // Just a single image, TODO: Generalize
    ArrayList<BufferedImage> carImage = new ArrayList<>() ;

    // To keep track of a single cars position

    Point saabPoint = new Point(0,0);
    Point volvoPoint = new Point(0,100);
    Point scaniaPoint = new Point(0,200);

    ArrayList<Point> carPointList = new ArrayList<>();


    // TODO: Make this general for all cars
    void moveit(int x, int y, String modelName){
        if(modelName.equals("Volvo240")) {
            volvoPoint.x = x;
            volvoPoint.y = y;
        }
        else if(modelName.equals("Saab95")){
            saabPoint.x = x;
            saabPoint.y = y;
        }
        else if(modelName.equals("Scania")){
            scaniaPoint.x = x;
            scaniaPoint.y = y;
        }
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Remember to right-click src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            carImage.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            carImage.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
            carImage.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));



        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(BufferedImage image : carImage){
            for(Point point : carPointList){
            g.drawImage(image, point.x, point.y, null); // see javadoc for more info on the parameters


    }
}
