package src;


public class Main{

    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        World world = new World(carFactory);
        DrawPanel drawPanel = new DrawPanel();
        world.addCarListObserver(drawPanel);
        world.notifyCarListObservers();
        world.addRemoveCarObserver(drawPanel);
        CarView frame = new CarView("CarSim 1.0", drawPanel, world);
        CarController cc = new CarController(frame, world);
        world.addPaintObserver(frame);
        world.timer.start();
    }
}

