package tec;

class PassagerStandard implements Passager {
    private String nom;
    private int destination;
    Position maPosition;

    public PassagerStandard(String nom, int destination){
        this.nom = nom;
        this.destination = destination;
        this.maPosition = new Position().dehors(); 
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

    public void monterDans(Vehicule v){
        if (v.aPlaceAssise()){
            this.changerEnAssis();
        }else if (v.aPlaceDebout()){
            this.changerEnDebout();
        }else {}
    }

    public String nom(){
        return this.nom;
    }

    public void nouvelArret(Vehicule v, int numeroArret){
        if (numeroArret == this.destination){
            this.changerEnDehors();
        }
        else {
            if (this.estDebout() && v.aPlaceAssise())
                this.changerEnAssis();
        }
    }

    @Override
    public String toString(){
        return "Nom : " + this.nom() + 
               "\nDestination : " + this.destination;
    }
}