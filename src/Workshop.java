package src;


import java.util.ArrayList;
import java.util.List;

public class Workshop<C extends Car> {

    private int MaxCapacity;

    public Workshop(int MaxCapacity){
        this.MaxCapacity = MaxCapacity;
    }

    private ArrayList<C> workShop = new ArrayList<>(MaxCapacity);

    public ArrayList<C> getArrayList(){return workShop;}

    public void turnInCar(C car) {
       if (workShop.size() < MaxCapacity){
        workShop.add(car);}
    }

    public void getCar(C car) {
        workShop.remove(car);
    }
}
















