package tec;

public class FabriqueTec {
    static public Usager fairePassagerStandard(String nom, int destination){
        return new PassagerStandard(nom, destination);
    }

    static public Transport faireAutobus(int nbPlaceAssise, int nbPlaceDebout){
        return new Autobus(nbPlaceAssise, nbPlaceDebout);
    }
}
