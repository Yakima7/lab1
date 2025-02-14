import org.junit.Before;
import org.junit.Test;
import src.Volvo240;
import src.Car;

import java.awt.*;

public class testVolvo240 {

    private Volvo240 volvo;

    @Before
    public void init() {
        volvo = new Volvo240();
        volvo.startEngine();
    }

    @Test
    public void testSpeedFactor() {
        double speedFactor = volvo.speedFactor();
        assert (1.25 == speedFactor);
    }

    @Test
    public void testIncrementSpeed() {
        volvo.incrementSpeed(10);
        assert (volvo.getCurrentSpeed() == 12.6);
        volvo.incrementSpeed(100);
        assert (volvo.getCurrentSpeed() == 100);

    }

    @Test
    public void decrementSpeed() {
        volvo.incrementSpeed(20);
        volvo.decrementSpeed(10);
        assert (Math.abs(volvo.getCurrentSpeed() - 12.6) <= 0.1);
    }

    @Test
    public void testMove() {
        volvo.move();
        assert (volvo.getYcoord() == 0.1 && volvo.getXcoord() == 0);
    }

    @Test
    public void testTurnLeft() {
        volvo.turnLeft();
        assert (volvo.getDirection() == Car.compass.West);
    }

    @Test
    public void testTurnRight() {
        volvo.turnRight();
        assert (volvo.getDirection() == Car.compass.East);
    }

    @Test
    public void testMovable() {
        volvo.move();
        volvo.turnRight();
        volvo.move();
        assert (volvo.getYcoord() == 0.1 && volvo.getXcoord() == 0.1);
    }

    @Test
    public void testGetNrDoors() {
        int doors = volvo.getNrDoors();
        assert (doors == 4);
    }

    @Test
    public void testGetEnginePower() {
        double power = volvo.getEnginePower();
        assert (power == 100);
    }

    @Test
    public void testGetColor() {
        assert (volvo.getColor() == Color.black);
    }

    @Test
    public void testSetColor() {
        volvo.setColor(Color.red);
        assert (volvo.getColor() == Color.red);
    }

    @Test
    public void testStopEngine() {
        volvo.stopEngine();
        assert (volvo.getCurrentSpeed() == 0);
    }

    @Test
    public void testCurrentSpeedUpperLimit() {
        volvo.incrementSpeed(150);
        assert (volvo.getCurrentSpeed() == 100);
    }

    @Test
    public void testCurrentSpeedLowerLimit() {
        volvo.decrementSpeed(500);
        assert (volvo.getCurrentSpeed() == 0);
    }

    @Test
    public void testGas() {
        volvo.gas(0.2);
        assert (volvo.getCurrentSpeed() == 0.35);

    }

    @Test
    public void testBrake() {
        volvo.incrementSpeed(0.2);
        volvo.brake(0.1);
        assert (Math.abs(volvo.getCurrentSpeed()-0.225) <= 0.01);
    }

    @Test
    public void testBrakeInterval(){
        volvo.brake(2);
        assert(volvo.getCurrentSpeed() == 0.1);
    }

    @Test
    public void testGasInterval(){
        volvo.gas(2);
        assert (volvo.getCurrentSpeed() == 0.1 );

    }


}
