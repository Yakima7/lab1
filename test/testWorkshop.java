import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src.*;

public class testWorkshop {
    private Workshop<Car> workshop;
    private Volvo240 carVolvo;
    private Volvo240 carVolvo2;
    private Saab95 carSaab;
    private Scania carScania;
    private Workshop<Volvo240> volvoWorkshop;
    private Workshop<Car> otherWorkshop;

    @Before
    public void init(){
        workshop = new Workshop<>(10);
        volvoWorkshop = new Workshop<>(10);
        carVolvo = new Volvo240();
        carVolvo2 = new Volvo240();
        carSaab= new Saab95();
        carScania = new Scania();
        otherWorkshop = new Workshop<>(3);

    }


    @Test
    public void testTurnInCar(){
        workshop.turnInCar(carScania);
        assert(workshop.getArrayList().get(0) == carScania);

    }
    @Test
    public void testTurnInCarVolvoWorkshop(){
        volvoWorkshop.turnInCar(carVolvo);
        assert(volvoWorkshop.getArrayList().get(0) == carVolvo);

    }


    @Test
    public void testGetCar(){
        workshop.turnInCar(carSaab);
        workshop.turnInCar(carScania);
        workshop.getCar(carSaab);
        assert(workshop.getArrayList().get(0) == carScania);
    }

    @Test
    public void testGetVolvo(){
        volvoWorkshop.turnInCar(carVolvo);
        volvoWorkshop.turnInCar(carVolvo2);
        volvoWorkshop.getCar(carVolvo);
        assert(volvoWorkshop.getArrayList().get(0) == carVolvo2);
    }

    @Test
    public void testMaxCapacity() {
        otherWorkshop.turnInCar(carVolvo);
        otherWorkshop.turnInCar(carVolvo2);
        otherWorkshop.turnInCar(carSaab);
        otherWorkshop.turnInCar(carScania);

        assert(otherWorkshop.getArrayList().size() == 3);

    }

  /*@Test
    public void testWrongTypeCar(){
        volvoWorkshop.turnInCar(carSaab);
    // Statiskt fel
    }*/


    }

