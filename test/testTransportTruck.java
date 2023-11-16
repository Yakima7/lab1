import org.junit.Before;
import org.junit.Test;
import src.Car;
import src.TransportTruck;
import src.Volvo240;
import java.util.ArrayList;


public class testTransportTruck {
    private TransportTruck transporttruck;
    private Volvo240 carEx;
    private Volvo240 carEx2;
    private ArrayList<Car> CarsOnTruck;

    @Before
    public void init() {transporttruck = new TransportTruck();
    carEx = new Volvo240();
    carEx2 = new Volvo240();
    CarsOnTruck = new ArrayList<Car>();
    //ArrayList<Car> CarsOnTruck = new ArrayList<Car>();
    transporttruck.setYcoord(1);
    transporttruck.setXcoord(1);
    carEx.setYcoord(0);
    carEx.setYcoord(0);
    carEx2.setYcoord(1);
    carEx2.setYcoord(0);
    transporttruck.angleDown();

    }
    //ArrayList<Car> CarsOnTruck = new ArrayList<Car>();

    //transporttruck.setYcoord(2);



    @Test
    public void TestAngleUp(){
        transporttruck.angleUp();
        assert (transporttruck.currentAngle==70);

    }

    @Test
    public void TestAngleDown(){
        transporttruck.angleDown();
        assert (transporttruck.currentAngle==0);

    }

    @Test
    public void TestLoadTruck(){
        transporttruck.LoadTruck(carEx);
        transporttruck.LoadTruck(carEx2);
        // ArrayList<Car> TheCars = transporttruck.getArrayList();
        assert(transporttruck.getArrayList().get(0) == carEx);

    }

    @Test
    public void TestUnLoadTruck(){
        transporttruck.LoadTruck(carEx);
        transporttruck.LoadTruck(carEx2);
        transporttruck.UnloadTruck(carEx2);
        assert(transporttruck.getArrayList().get(0) == carEx);

    }



}
