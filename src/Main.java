package src;

public class Main {

    public static void main(String[] args) {
        // Start a new view and send a reference of self
        CarView frame = new CarView("CarSim 1.0", cc);

        // Instance of this class
        CarController cc = new CarController(frame);


    }

    public CarController getCarController(){return cc;}

}
