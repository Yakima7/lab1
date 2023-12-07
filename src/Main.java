package src;

public class Main {

//CarController cc;

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        World world = new World();

        // Start a new view and send a reference of self
        CarView frame = new CarView("CarSim 1.0", cc);
        world.timer.start();
    }

    //public CarController getCarController(){return cc;}

}
