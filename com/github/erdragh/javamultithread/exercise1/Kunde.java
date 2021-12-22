package com.github.erdragh.javamultithread.exercise1;

public class Kunde extends Thread {
    /**Referenzen auf die Z&uuml;ge mit M&ouml;glichkeit der Information und Buchung*/
    private Zug[] zuege;

    /** Konstruktor der Klasse
     * @param name Name des Kunden
     * @param zuege Referenzen auf buchbare Z&uuml;ge
     */
    public Kunde(String name, Zug[] zuege) {
        super(name);
        this.zuege = zuege;
    }

    /**Der Kunde bucht zufallsgesteuert in den verschiedenen Z&uuml;gen*/
    @Override
    public void run() {
        int auswahl;

        for (int i = 0; i < 10; i++) {

            //Bearbeitungsdauer
            try {
                sleep((int) (Math.random() * 3000));
            } catch (InterruptedException e) {
            }

            //Buchung des ersten Teils der Verbindung
            if ((int)(Math.random()*2) % 2 == 0) {
                auswahl = 0;
            } else {
                auswahl = 1;
            }
            String leerzeichen = "";
            if (getName().equals("Kunde 2")) leerzeichen = "                                         ";
            
            System.out.println(leerzeichen + getName() + ": Platz " + zuege[auswahl].nochFrei()
                    + " im " + zuege[auswahl].getName() + " und ...");

            //Bearbeitungsdauer                    
            try {
                sleep((int) (Math.random() * 3000));
            } catch (InterruptedException e) {
            }     
            
            //Buchung des zweiten Teils der Verbindung
            auswahl = 1 - auswahl;
            System.out.println(leerzeichen + getName() + ": ... Platz " + zuege[auswahl].nochFrei()
                    + " im " + zuege[auswahl].getName());            
            
        }
    }
    
    public void buchen(){
    
    }
}
