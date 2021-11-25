package tec;


public class PassagerIndecis extends PassagerAbstrait {

    public PassagerIndecis(String nom, int destination) {
        super(nom, destination);
    }

    @Override
    void choixPlaceMontee(Vehicule v) {
        if (v.aPlaceDebout()){
            v.monteeDemanderDebout(this);
        } else {}
    }

    @Override
    void choixPlaceArret(Vehicule v, int numeroArret) {
        if (this.estAssis()){
            if (v.aPlaceDebout()){
                v.arretDemanderDebout(this);;
            }
        } else if (this.estDebout()){
            if (v.aPlaceDebout()){
                v.arretDemanderAssis(this);
            }
        } else {}
    }


}