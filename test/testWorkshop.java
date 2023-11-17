import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src.*;

public class testWorkshop {
    private Workshop<Car> workshop;
    private Volvo240 carVolvo;
    private Volvo240 carVolvo2;
    private Saab95 carSaab;
    private Scania carSaab2;
    private TransportTruck exTransportTruck;
    private Workshop<Volvo240> volvoWorkshop;
    private Workshop<Truck> truckWorkshop;
    private Workshop<Car> otherWorkshop;

    @Before
    public void init(){
        workshop = new Workshop<>(10);
        volvoWorkshop = new Workshop<>(10);
        truckWorkshop = new Workshop<>(3);
        carVolvo = new Volvo240();
        carVolvo2 = new Volvo240();
        carSaab= new Saab95();
        carSaab2 = new Scania();
        exTransportTruck = new TransportTruck();
        otherWorkshop = new Workshop<>(3);

    }


    @Test
    public void testTurnInCar(){
        workshop.turnInCar(carSaab2);
        assert(workshop.getArrayList().get(0) == carSaab2);

    }
    @Test
    public void testTurnInCarTruckWorkshop(){
        truckWorkshop.turnInCar(carSaab2);
        assert(truckWorkshop.getArrayList().get(0) == carSaab2);

    }


    @Test
    public void testGetCar(){
        workshop.turnInCar(carSaab);
        workshop.turnInCar(carSaab2);
        workshop.getCar(carSaab);
        assert(workshop.getArrayList().get(0) == carSaab2);
    }

    @Test
    public void testGetTruck(){
        truckWorkshop.turnInCar(carSaab2);
        truckWorkshop.turnInCar(exTransportTruck);
        truckWorkshop.getCar(carSaab2);
        assert(truckWorkshop.getArrayList().get(0) == exTransportTruck);
    }

    @Test
    public void testMaxCapacity() {
        otherWorkshop.turnInCar(carVolvo);
        otherWorkshop.turnInCar(carVolvo2);
        otherWorkshop.turnInCar(carSaab);
        otherWorkshop.turnInCar(carSaab2);

        assert(otherWorkshop.getArrayList().size() == 3);

    }

  /*@Test
    public void testWrongTypeCar(){
        volvoWorkshop.turnInCar(carSaab);
    // Statiskt fel
    }*/


    }

