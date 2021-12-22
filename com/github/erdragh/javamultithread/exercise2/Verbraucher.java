package com.github.erdragh.javamultithread.exercise2;

public class Verbraucher extends Thread {
    // Attribute
    private Speicher meinSpeicher;
    private int wartezeit;
    
    // Konstruktor
    public Verbraucher(String nameEingeben, Speicher speEingeben, int wEingeben)
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
            
            System.out.println(getName() + " - Holen aufgerufen");       
            
            meinSpeicher.kisteHolen();
            
            System.out.println(getName() + " - Holen beendet - Anzahl: " + meinSpeicher.getAnzahl());  
        }
    }
}
