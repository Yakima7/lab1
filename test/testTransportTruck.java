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


    @Before
    public void init() {transporttruck = new TransportTruck();
    carEx = new Volvo240();
    carEx2 = new Volvo240();
    }




    @Test
    public void TestAngleUp(){
        transporttruck.angleUp();
        assert (transporttruck.currentAngle==70);

    }

    @Test
    public void TestAngleDown(){
        transporttruck.setRampDown();
        assert (transporttruck.getRampStatus());

    }

    @Test
    public void TestLoadTruck(){
        transporttruck.setRampDown();
        transporttruck.LoadTruck(carEx);
        transporttruck.LoadTruck(carEx2);
        assert(transporttruck.getArrayList().get(0) == carEx);

    }

    @Test
    public void TestUnLoadTruck(){
        transporttruck.setRampDown();
        transporttruck.LoadTruck(carEx);
        transporttruck.LoadTruck(carEx2);
        transporttruck.UnloadTruck(carEx2);
        assert(transporttruck.getArrayList().get(0) == carEx);

    }


}
