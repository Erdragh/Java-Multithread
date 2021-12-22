package com.github.erdragh.javamultithread.exercise2;

public class Erzeuger extends Thread {
    // Attribute
    private Speicher meinSpeicher;
    private int wartezeit;

    // Konstruktor
    public Erzeuger(String nameEingeben, Speicher speEingeben, int wEingeben)
    {
        super(nameEingeben);
        meinSpeicher = speEingeben;
        wartezeit = wEingeben;
    }


    // Methoden
    public void run(){
        while(true){
            try {
                Thread.sleep((int) (java.lang.Math.random()*wartezeit));
            } catch (InterruptedException e) {}       
            
            System.out.println("                                        " + getName() + " - Legen aufgerufen");            
            
            meinSpeicher.kisteLegen();
            
            System.out.println("                                        " + getName() + " - Legen beendet - Anzahl: " + meinSpeicher.getAnzahl());               
        }
    }
}
