import org.junit.Before;
import org.junit.Test;
import src.Scania;
import src.cars;

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
}



