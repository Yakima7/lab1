package src;

public class Main {


    public static void main(String[] args) {

        // Instance of this class
        CarController cc = new CarController();
        DrawPanel drawPanel = new DrawPanel(world);
        // Start a new view and send a reference of self
        CarView frame = new CarView("CarSim 1.0", cc);
        world.timer.start();
    }

    //public CarController getCarController(){return cc;}

}
