package tec;

public class Autobus implements Vehicule{
    private int numeroArret;
    private final Jauge debout;
    private final Jauge assis;
    private Passager[] passagersAssis;
    private Passager[] passagerdebouts;

    public Autobus(int nbPlaceAssise, int nbPlaceDebout){
        this.numeroArret = 0;
        this.debout = new Jauge(nbPlaceDebout, 0);
        this.assis = new Jauge(nbPlaceAssise, 0);
        this.passagersAssis = new Passager[nbPlaceAssise];
        this.passagerdebouts = new Passager[nbPlaceDebout];
    }

    /*
        @param passagers : tableau de passagers
        @return l'emplacement d'un passager vide
    */
    private int emplacementVide(Passager[] passagers){
        for(int i = 0; i < passagers.length; i++){
            if(passagers[i] == null)
                return i;
        }
        return -1;
    }
    
    private int emplacementVideDebout(){
        return emplacementVide(this.passagerdebouts);
    }

    private int emplacementVideAssis(){
        return emplacementVide(this.passagersAssis);
    }

    public void allerArretSuivant() {
        this.numeroArret++;
        for (Passager passager : passagerdebouts){
            if (passager != null)
                passager.nouvelArret(this, this.numeroArret);
        }
        for (Passager passager : passagersAssis){
            if (passager != null)
                passager.nouvelArret(this, this.numeroArret);
        }
        
    }

    public boolean aPlaceAssise() {
        return this.assis.estVert();
    }

    
    public boolean aPlaceDebout() {
        return this.debout.estVert();
    }

    public void monteeDemanderAssis(Passager p) {
        p.changerEnAssis();
        int emplacement = this.emplacementVideAssis();
        this.passagersAssis[emplacement] = p;
        this.assis.incrementer();
    }

    
    public void monteeDemanderDebout(Passager p) {
        p.changerEnDebout();
        int emplacement = this.emplacementVideDebout();
        this.passagerdebouts[emplacement] = p;
        this.debout.incrementer();
    }

    private int chercherPassager(Passager[] passagers, Passager p){
        for (int i = 0; i < passagers.length; i++){
            if (passagers[i] == p){
                return i;
            }
        }
        return -1;
    }


    public void arretDemanderDebout(Passager p) {
        p.changerEnDebout();
        int emplacement = this.chercherPassager(passagersAssis, p);
        passagersAssis[emplacement] = null;
        
        int emplacementVideDebout = this.emplacementVideDebout();
        this.passagerdebouts[emplacementVideDebout] = p;

        this.assis.decrementer();
        this.debout.incrementer();
    }

    public void arretDemanderAssis(Passager p) {
        p.changerEnAssis();
        int emplacement = this.chercherPassager(passagerdebouts, p);
        passagerdebouts[emplacement] = null;

        int emplacementVideAssis = this.emplacementVideDebout();
        this.passagersAssis[emplacementVideAssis] = p;

        this.assis.incrementer();
        this.debout.decrementer();
    }

    public void arretDemanderSortie(Passager p) {        
        if (p.estAssis()){
            this.assis.decrementer();
            this.passagersAssis[chercherPassager(passagersAssis, p)] = null;
        }else {
            this.debout.decrementer();
            this.passagerdebouts[chercherPassager(passagerdebouts, p)] = null;
        }
        p.changerEnDehors();
    }

    @Override
    public String toString(){
        return "[arret " + this.numeroArret + "] " +
               "assis" + this.assis.toString() +
               " debout" + this.debout.toString() ;
    }
}
