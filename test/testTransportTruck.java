import org.junit.Before;
import org.junit.Test;;
import src.TransportTruck;


public class testTransportTruck {
    private TransportTruck transporttruck;

    @Before
    public void init() {transporttruck = new TransportTruck();}

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

    }

    @Test
    public void TestUnLoadTruck(){

    }



}
