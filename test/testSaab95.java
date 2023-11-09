import org.junit.Before;
import org.junit.Test;
import src.Saab95;
import src.cars;

public class testSaab95 {

    private Saab95 saab;

    @Before
    public void init(){
        saab = new Saab95();
        saab.startEngine();
    }
    @Test
    public void testSpeedFactor(){
        double speedFactor = saab.speedFactor();
        assert(1.25 == speedFactor);
        saab.setTurboOn();
        double speedFactorWithTurbo = saab.speedFactor();
        assert(1.625 == speedFactorWithTurbo);
    }

    @Test
    public void testIncrementSpeed(){
        saab.incrementSpeed(10);
        assert(saab.currentSpeed == 12.6);
    }

    @Test
    public void decrementSpeed(){
        saab.incrementSpeed(20);
        saab.decrementSpeed(10);
        assert(Math.abs(saab.currentSpeed - 12.6) <= 0.1);
    }

    @Test
    public void testMove(){
        saab.move();
        assert(saab.ycoord == 0.1 && saab.xcoord == 0);
    }

    @Test
    public void testTurnLeft(){
        saab.turnLeft();
        assert(saab.direction == cars.compass.West);
    }

    @Test
    public void testTurnRight(){
        saab.turnRight();
        assert(saab.direction == cars.compass.East);
    }

    @Test
    public void testMovable(){
        saab.move();
        saab.turnRight();
        saab.move();
        assert(saab.ycoord == 0.1 && saab.xcoord == 0.1);
    }
}
