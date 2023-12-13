package src;

public class Main {


    public static void main(String[] args) {
        World world = new World();
        DrawPanel drawPanel = new DrawPanel();
        world.addCarListObserver(drawPanel);
        //world.addCarListObserver(world.timer);
        CarController cc = new CarController(world);
        CarView frame = new CarView("CarSim 1.0", cc, drawPanel);
        world.addPaintObserver(frame);

        // Instance of this class
        CarController cc = new CarController();
        DrawPanel drawPanel = new DrawPanel(world);
        // Start a new view and send a reference of self
        world.timer.start();
    }

    //public CarController getCarController(){return cc;}

}
