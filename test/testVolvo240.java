import org.junit.Before;
import org.junit.Test;
import src.Volvo240;
import src.cars;

public class testVolvo240 {

    private Volvo240 volvo;

    @Before
    public void init(){
        volvo = new Volvo240();
        volvo.startEngine();
    }

    @Test
    public void testSpeedFactor(){
        double speedFactor = volvo.speedFactor();
        assert(1.25 == speedFactor);
    }
    @Test
    public void testIncrementSpeed(){
        volvo.incrementSpeed(10);
        assert(volvo.currentSpeed == 12.6);
        volvo.incrementSpeed(100);
        assert(volvo.currentSpeed == 100);

    }

    @Test
    public void decrementSpeed(){
        volvo.incrementSpeed(20);
        volvo.decrementSpeed(10);
        assert(Math.abs(volvo.currentSpeed - 12.6) <= 0.1);
    }

    @Test
    public void testMove(){
        volvo.move();
        assert(volvo.ycoord == 0.1 && volvo.xcoord == 0);
    }

    @Test
    public void testTurnLeft(){
        volvo.turnLeft();
        assert(volvo.direction == cars.compass.West);
    }

    @Test
    public void testTurnRight(){
        volvo.turnRight();
        assert(volvo.direction == cars.compass.East);
    }

    @Test
    public void testMovable(){
        volvo.move();
        volvo.turnRight();
        volvo.move();
        assert(volvo.ycoord == 0.1 && volvo.xcoord == 0.1);
    }



    // @Test
    // public void testGas(){
    // volvo.gas(0.2);
    // assert(

    //}

}
