package com.github.erdragh.javamultithread.exercise1;

public class Zug {
    /** die Platznummer im Zug*/
    private int platz;
    /** der Name des Zuges*/
    private String name;

    /**Konstruktor
     *
     * @param name der Name des Zuges.
     */
    public Zug(String name, int platz) {
        this.name = name;
        this.platz = platz;
    }

    /**gibt den Namen des Zuges zur&uuml;ck
     *
     * @return der Name des Zuges
     */
    public String getName() {
        return name;
    }

    /**gibt den n&auml;chsten freien Platz zur&uuml;ck,
     * es wird in aufsteigender Reihenfolge gebucht.
     * 
     * @return der n&auml;chsten freie und damit buchbare Platz
     */
    public int nochFrei() {
        int n = platz; // letzten reservierten Platz lesen
        
        try {   	// denn das Verarbeiten braucht etwas Zeit ...
            Thread.sleep((int) (Math.random() * 500));
        } catch (InterruptedException e) {
        }
        
        platz = n+1; // naechsten (freien) Platz "ermittlen und belegen"
        
        return platz; // und zurueckgeben
    }
}
