package src;

public class World {
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount)/100;
        for (Car car : cars){
            car.brake(brake);
        }
    }

    void turboOn(){
        Saab95 saab = (Saab95) cars.get(1);
        saab.setTurboOn();
    }

    void turboOff(){
        Saab95 saab = (Saab95) cars.get(1);
        saab.setTurboOff();
    }

    void liftBed(int angle){
        Scania scania = (Scania) cars.get(2);
        scania.changeAngleUp(angle);
    }

    void lowerBed(int angle){
        Scania scania = (Scania) cars.get(2);
        scania.changeAngleDown(angle);
    }

    void start(){
        for (Car car : cars){
            car.startEngine();
        }
    }
    void stop(){
        for (Car car : cars){
            car.stopEngine();
        }
    }
}
