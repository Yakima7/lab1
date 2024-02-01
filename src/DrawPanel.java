package src;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel implements CarListObserver, RemoveCarObserver, PaintObserver{
    private static final int X = 800;
    private static final int Y = 800;

    ArrayList<BufferedImage> carImage = new ArrayList<>();

    Map<Car, BufferedImage> carPic = new HashMap<>();

    public int getX(){
        return X;
    }
    public int getY(){
        return Y;
    }

    // Initializes the panel and reads the images
    public DrawPanel() {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(X, Y-240));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            carImage.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            carImage.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
            carImage.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void update(ArrayList<Car> cars){
        for (Car car : cars) {
            if (car.getModelName().equals("Volvo240")) {
                carPic.put(car, carImage.get(0));
            } else if (car.getModelName().equals("Saab95")) {
                carPic.put(car, carImage.get(1));
            } else if (car.getModelName().equals("Scania")) {
                carPic.put(car, carImage.get(2));
            }
        }
        repaint();
    }

    @Override
    public void removeCar(ArrayList<Car>cars){
        Car car = cars.getLast();
        carPic.remove(car);
    }
    @Override
    public void updatePaint(){
        paintComponent(getGraphics());
    }
    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car : carPic.keySet()) {
                g.drawImage(carPic.get(car), car.getXcoord(), car.getYcoord(), null);
            }
    }
}

