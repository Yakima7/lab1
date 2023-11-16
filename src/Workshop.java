package src;

//Parametrisk polymorfism uppnår the open-closed Principle.
//Då man kan sätta in vilken typ som helst.

public class Workshop<C extends Car> {
    //Ta bort extends? Lämna C till en allmän typ?
    //Kommer då gälla för alla slags typer, gäller nu för endast Car, inklusive Volvo, Saab... (tror jag)
    //C blir nu en subtyp till Car och kan då anropa "car-saker" till den och cars subklasser
    //Workshop<Interger> skulle nu ge statiskt fel, mycket bra!
    //Typparametern har nu en upper-bound
    public C[] allCarsGarage;
    public void allCarsGarage(int size) {
        allCarsGarage = (C[]) new Object[size];
    }


    public void addCar(C car){


    }



}
