package com.github.erdragh.javamultithread.exercise2;

public class Speicher {
    // Attribute
    private int anzahl;
    private final int max;

    // Konstruktor
    public Speicher(int maxEingeben, int startEingeben)
    {
        anzahl = startEingeben;
        max = maxEingeben;
    }


    // Methoden
    public int getAnzahl(){
        return anzahl;
    }    
    
    public synchronized void kisteLegen(){
        if (anzahl >= max) {
            System.out.println("full");
            while(anzahl >= max) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        anzahl++;
        notifyAll();
        // pr�ft, ob das Lager voll ist
        // wenn ja, dann gibt eine Meldung im Konsolenfenster aus
        //          ... und wartet solange das Lager noch voll ist
        // wenn nein, bzw. anschlie�end, legt die Kiste ab
    }
    
    public synchronized void kisteHolen(){
        if (anzahl <= 0) {
            System.out.println("leer");
            while (anzahl <= 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        anzahl--;
        notifyAll();
        // pr�ft, ob das Lager leer ist
        // wenn ja, dann gibt eine Meldung im Konsolenfenster aus
        //          ... und wartet solange das Lager noch leer ist
        // wenn nein, bzw. anschlie�end, nimmt die Kiste auf
    }


//// Code f�r eine zuf�llige Bearbeitungszeit
//         try {
//             Thread.sleep((int) (java.lang.Math.random()*500));
//         } catch (InterruptedException e) {}   


}
