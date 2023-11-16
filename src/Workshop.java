package src;

//Parametrisk polymorfism uppnår the open-closed Principle.
//Då man kan sätta in vilken typ som helst.

import java.util.ArrayList;
import java.util.List;

public class Workshop {
    //Ta bort extends? Lämna C till en allmän typ?
    //Kommer då gälla för alla slags typer, gäller nu för endast Car, inklusive Volvo, Saab... (tror jag)
    //C blir nu en subtyp till Car och kan då anropa "car-saker" till den och cars subklasser
    //Workshop<Interger> skulle nu ge statiskt fel, mycket bra!
    //Typparametern har nu en upper-bound


    //Skapa en workshop initsierare
    /*Workshop(int Maxcapacity, ? carTypeAccepted ){this.Maxcapacity=Maxcapacity;
     this.carTypeAccepted=carTypeAccepted;}  */

    private int MaxCapacity = 10;


    private List<Car> workShop = new ArrayList<>(MaxCapacity);

    public List<Car> getArrayList(){return workShop;}

    public void turnInCar(Car car) {
       if (workShop.size() < MaxCapacity){
        workShop.add(car);}
    }

    public void getCar(Car car) {
        workShop.remove(car);
    }
}
















