package tec;



class TestPosition {

    private String errorMessage(Position p){
        return "Assis : " + p.estAssis() +
               "| Debout : " + p.estDebout() +
               "| Dehors : " + p.estDehors() ;
    }
    public static void main(String[] args) {
        
        boolean estMisAssertion = false;
        assert estMisAssertion = true;
    
        if (estMisAssertion == false){
            System.out.println("Execution impossible sans l'option -ea");
            return;
        }

        TestPosition tp = new TestPosition();
        int nbTest = 0;

        System.out.println("Testing Position ...");

        String OKAssis = tp.testAssis() ? "OK" : "NOT OK";
        System.out.println("    Assis : " + OKAssis);
        nbTest++;

        String OKDebout = tp.testDebout() ? "OK" : "NOT OK";
        System.out.println("    Debout : " + OKDebout);
        nbTest++;

        String OKDehors = tp.testDehors() ? "OK" : "NOT OK";
        System.out.println("    Dehors : " + OKDehors);
        nbTest++;

        String OKInterieur = tp.testInterieur() ? "OK" : "NOT OK";
        System.out.println("    Interieur : " + OKInterieur);
        nbTest++;

        System.out.println("    Done : Tests(" + nbTest +"/4)");
    }

    private boolean testAssis(){
        Position p = Position.creerPositionInitiale();
        Position pAssis = p.assis();

        assert pAssis.estAssis() : this.errorMessage(pAssis) ;
        assert !pAssis.estDebout() : this.errorMessage(pAssis);
        assert !pAssis.estDehors() : this.errorMessage(pAssis);

        return true;
    }

    private boolean testDebout(){
        Position p = Position.creerPositionInitiale();
        Position pDebout = p.debout();

        assert !pDebout.estAssis() : this.errorMessage(pDebout) ;
        assert pDebout.estDebout() : this.errorMessage(pDebout);
        assert !pDebout.estDehors() : this.errorMessage(pDebout);

        return true;
    }

    private boolean testDehors(){
        Position p = Position.creerPositionInitiale();
        Position pDehors = p.dehors();

        assert !pDehors.estAssis() : this.errorMessage(pDehors) ;
        assert !pDehors.estDebout() : this.errorMessage(pDehors);
        assert pDehors.estDehors() : this.errorMessage(pDehors);

        return true;
    }

    private boolean testInterieur(){
        Position p = Position.creerPositionInitiale();
        
        double a = Math.random();
        Position pInterieur = (a > 0.5) ? p.assis() : p.debout();


        assert pInterieur.estAssis() || pInterieur.estDebout() : this.errorMessage(pInterieur) ;
        assert !pInterieur.estDehors() : this.errorMessage(pInterieur);

        return true;
    }

}