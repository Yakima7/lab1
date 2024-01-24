package src;
import java.util.Random;

public class CarFactory {

    public Car createCar(){
        Random random = new Random();
        int carNr = random.nextInt(3);

        return switch (carNr) {
            case 0 -> new Volvo240();
            case 1 -> new Saab95();
            default -> new Scania();
        };
    }
}
