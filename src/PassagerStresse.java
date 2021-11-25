package tec;

public class PassagerStresse extends PassagerAbstrait{

    public PassagerStresse(String nom, int destination) {
        super(nom, destination);
    }

    @Override
    void choixPlaceMontee(Vehicule v) {
        if (v.aPlaceAssise()){
            v.monteeDemanderAssis(this);
        } else if (v.aPlaceDebout()){
            v.monteeDemanderDebout(this);
        } else {}
    }

    @Override
    void choixPlaceArret(Vehicule v, int numeroArret) {
        if (this.get_destination() - 3 <= numeroArret){
            if (v.aPlaceDebout()){
                v.arretDemanderDebout(this);
            }
        }
        
    }
    
}
