import org.junit.Before;
import org.junit.Test;
import src.Scania;

public class testScania {
    private Scania scania;

    @Before
    public void init() {
        scania = new Scania();
    }

    @Test
    public void testAngleUp(){
       scania.ChangeAngleUp(20);
       assert (scania.currentAngle==20);

    }

    @Test
    public void testMove() {
        scania.startEngine();
        scania.move();
        assert (scania.getXcoord() == 0 && scania.getYcoord() == 0.1);
    }

    @Test
    public void testMoveAngledUp(){
        scania.ChangeAngleUp(20);
        scania.startEngine();
        scania.move();
        assert (scania.getXcoord() == 0 && scania.getYcoord() == 0);
    }
}



