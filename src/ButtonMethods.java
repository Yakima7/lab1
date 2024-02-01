package src;
import java.util.ArrayList;

public class ButtonMethods {
    CarFactory carFactory;
    World world;

    public ButtonMethods(CarFactory carFactory, World world){
        this.carFactory = carFactory;
        this.world = world;
    }

    //CarListObserver
    private ArrayList<CarListObserver> carListeners = new ArrayList<>();

    public void addCarListObserver(CarListObserver carListener) {
        this.carListeners.add(carListener);
    }

    public void removeCarListObserver(CarListObserver carListener) {
        this.carListeners.remove(carListener);
    }

    public void notifyCarListObservers() {
        for (CarListObserver listener : this.carListeners) {
            listener.update(world.getList());
        }
    }
    //RemoveCarObserver
    private ArrayList<RemoveCarObserver> removeCarListener = new ArrayList<>();

    public void addRemoveCarObserver(RemoveCarObserver removeCarListener){
        this.removeCarListener.add(removeCarListener);
    }

    public void removeRemoveCarObserver(RemoveCarObserver removeCarListener){
        this.removeCarListener.remove(removeCarListener);
    }

    public void notifyRemoveCarObservers(ArrayList<Car>cars) {
        for (RemoveCarObserver listener : this.removeCarListener) {
            listener.removeCar(cars);
        }
    }

    //Methods for buttons

    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : world.getList()) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount)/100;
        for (Car car : world.getList()){
            car.brake(brake);
        }
    }

    void turboOn() {
        for (Car car : world.getList()) {
            if(car.getModelName().equals("Saab95")){
                Saab95 saab = (Saab95) car;
                saab.setTurboOn();
            }
        }
    }

    void turboOff(){
        Saab95 saab = (Saab95) world.getList().get(1);
        saab.setTurboOff();
    }

    void liftBed(int angle){
        Scania scania = (Scania) world.getList().get(2);
        scania.changeAngleUp(angle);
    }

    void lowerBed(int angle){
        Scania scania = (Scania) world.getList().get(2);
        scania.changeAngleDown(angle);
    }

    void start(){
        for (Car car : world.getList()){
            car.startEngine();
        }
    }
    void stop(){
        for (Car car : world.getList()){
            car.stopEngine();
        }
    }

    void addCar() {
        if (world.getList().size() < 10) {
            Car newCar = carFactory.createCar();
            world.getList().add(newCar);
            world.updateCarList(world.getList());
            notifyCarListObservers();
        }
    }

    void removeCar() {
        if (!world.getList().isEmpty()) {
            notifyRemoveCarObservers(world.getList());
            world.getList().remove(world.getList().getLast());
            world.notifyPaintObservers();
        }
    }
}
