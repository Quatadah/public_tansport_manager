package tec;

abstract class PassagerAbstrait implements Passager, Usager {
    private String nom;
    private int destination;
    Position maPosition;

    public PassagerAbstrait(String nom, int destination){
        this.nom = nom;
        this.destination = destination;
        this.maPosition = Position.creerPositionInitiale(); 
    }

    
    public void changerEnAssis(){
        this.maPosition = maPosition.assis();
    }

    
    public void changerEnDebout(){
        this.maPosition = maPosition.debout();
    }

    public void changerEnDehors(){
        this.maPosition = maPosition.dehors();
    }

    public boolean estAssis(){
        return maPosition.estAssis();
    }

    public boolean estDebout(){
        return maPosition.estDebout();
    }

    public boolean estDehors(){
        return maPosition.estDehors();
    }

    int get_destination(){
        return destination;
    }

    abstract void choixPlaceMontee(Vehicule v);

    abstract void choixPlaceArret(Vehicule v, int numeroArret);

    public final void monterDans(Transport t){
        Vehicule v = (Vehicule) t;
        choixPlaceMontee(v);
    }

    public String nom(){
        return this.nom;
    }

    final public void nouvelArret(Vehicule v, int numeroArret){
        if (numeroArret == this.destination){
            v.arretDemanderSortie(this);
        }
        else {
            choixPlaceArret(v, numeroArret);
        }
    }

    @Override
    public String toString(){
        String pos = maPosition.estAssis() ? "assis" : maPosition.estDebout() ? "debout" : "dehors";
        return this.nom() + " <" + pos  + ">";
    }
}