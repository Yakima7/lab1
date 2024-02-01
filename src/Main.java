package src;


public class Main{

    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        World world = new World(carFactory);
        DrawPanel drawPanel = new DrawPanel();
        methods.addCarListObserver(drawPanel);
        methods.notifyCarListObservers();
        methods.addRemoveCarObserver(drawPanel);
        CarView frame = new CarView("CarSim 1.0", drawPanel);
        CarController cc = new CarController(frame, methods);
        world.addPaintObserver(drawPanel);
        world.timer.start();
    }
}

