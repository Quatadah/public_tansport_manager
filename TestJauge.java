class TestJauge {
    public static void main(String[] args) {
        boolean estMisAssertion = false;
        assert estMisAssertion = true;
    
        if (estMisAssertion == false){
            System.out.println("Execution impossible sans l'option -ea");
            return;
        }

        TestJauge tj = new TestJauge();
        int nbTest = 0;
        System.out.println("Testing Jauge ... ");

        String OK1 = tj.testInferieur0() ? "OK" : "NOT OK";
        System.out.println("    testInferieur0 : " + OK1);
        nbTest++;

        String OK2 = tj.testEgale0() ? "OK" : "NOT OK";
        System.out.println("    testEgale0 : " + OK2  );
        nbTest++;

        String OK3 = tj.testEgaleMax() ? "OK" : "NOT OK";
        System.out.println("    testEgaleMax : " + OK3  );
        nbTest++;
        
        String OK4 = tj.testSuperieurMax() ? "OK" : "NOT OK";
        System.out.println("    testSuperieurMax : " + OK4  );
        nbTest++;

        String OK5 = tj.testIncrementer() ? "OK" : "NOT OK";
        System.out.println("    testIncrementer : " + OK5  );
        nbTest++;

        String OK6 = tj.testDecrementer() ? "OK" : "NOT OK";
        System.out.println("    testDecrementer : " + OK6  );
        nbTest++;

        System.out.println("    Done : Tests(" + nbTest +"/6)");

    }

    private String isGreen(){
        return "0 <= depart <= max";
    }

    private String isRed(){
        return " depart < 0 or depart >= max";
    }

    private boolean testSuperieurMax(){
        int depart = 101;
        int max = 100;
        Jauge j = new Jauge(depart, max);
        assert j.estRouge() : this.isGreen();
        assert !j.estVert() : this.isGreen();

        return true;
    }

    private boolean testEgaleMax(){
        int depart = 100;
        int max = 100;
        Jauge j = new Jauge(depart, max);
        assert j.estRouge() : this.isGreen();
        assert !j.estVert() : this.isGreen();

        return true;

    }

    private boolean testEgale0(){
        int depart = 0;
        int max = 100;
        Jauge j = new Jauge(depart, max);
        assert j.estVert() : this.isRed();
        assert !j.estRouge() : this.isRed();

        return true;
    }
    private boolean testInferieur0(){
        int depart = -1;
        int max = 100;
        Jauge j = new Jauge(depart, max);
        assert j.estRouge() : this.isGreen();
        assert !j.estVert() : this.isGreen();

        return true;
    }
    
    private boolean testIncrementer(){
        int depart = 99;
        int max = 100;
        Jauge j = new Jauge(depart, max);
        j.incrementer();
        assert j.estRouge() : this.isGreen();
        assert !j.estVert() : this.isGreen();
        return true;
    }

    private boolean testDecrementer(){
        int depart = 100;
        int max = 100;
        Jauge j = new Jauge(depart, max);
        j.decrementer();
        assert !j.estRouge() : this.isRed();
        assert j.estVert() : this.isRed();
        return true;
    }



}