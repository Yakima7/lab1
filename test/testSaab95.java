import org.junit.Before;
import org.junit.Test;
import src.Saab95;
import src.Car;

import java.awt.*;

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
        assert(saab.getCurrentSpeed() == 12.6);
    }

    @Test
    public void decrementSpeed(){
        saab.incrementSpeed(20);
        saab.decrementSpeed(10);
        assert(Math.abs(saab.getCurrentSpeed() - 12.6) <= 0.1);
    }

    @Test
    public void testMove(){
        saab.move();
        assert(saab.getYcoord() == 0.1 && saab.getXcoord() == 0);
    }

    @Test
    public void testTurnLeft(){
        saab.turnLeft();
        assert(saab.getDirection() == Car.compass.West);
    }

    @Test
    public void testTurnRight(){
        saab.turnRight();
        assert(saab.getDirection() == Car.compass.East);
    }

    @Test
    public void testMovable(){
        saab.move();
        saab.turnRight();
        saab.move();
        assert(saab.getYcoord() == 0.1 && saab.getXcoord() == 0.1);
    }
    @Test
    public void testGetNrDoors(){
        int doors = saab.getNrDoors();
        assert(doors == 2);
    }

    @Test
    public void testGetEnginePower(){
        double power = saab.getEnginePower();
        assert(power == 125);
    }

    @Test
    public void testGetColor(){
        assert(saab.getColor() == Color.red);
    }

    @Test
    public void testSetColor(){
        saab.setColor(Color.black);
        assert(saab.getColor() == Color.black);
    }

    @Test
    public void testStopEngine(){
        saab.stopEngine();
        assert(saab.getCurrentSpeed() == 0);
    }
    @Test
    public void testCurrentSpeedUpperLimit(){
        saab.incrementSpeed(150);
        assert(saab.getCurrentSpeed() == 125);
    }

    @Test
    public void testCurrentSpeedLowerLimit(){
        saab.decrementSpeed(500);
        assert(saab.getCurrentSpeed() == 0);
    }

    @Test
    public void testGas() {
        saab.gas(0.2);
        assert (saab.getCurrentSpeed() == 0.35);

    }

    @Test
    public void testBrake() {
        saab.incrementSpeed(0.2);
        saab.brake(0.1);
        assert (Math.abs(saab.getCurrentSpeed()-0.225) <= 0.01);
    }

    @Test
    public void testBrakeInterval(){
        saab.brake(2);
        assert(saab.getCurrentSpeed() == 0.1);
    }

    @Test
    public void testGasInterval(){
        saab.gas(2);
        assert (saab.getCurrentSpeed() == 0.1 );

    }
}
