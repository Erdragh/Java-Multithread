package com.github.erdragh.javamultithread.exercise3;

// Klasse SpeicherP
public class SpeicherP{

    // Attribute
    private int anzahl, max;

    // Konstruktor
    public SpeicherP(int _max, int anzahlStart)
    {
        anzahl = anzahlStart;
        max = _max;
    }

    // Methoden
    public int getAnzahl(){
        return anzahl;
    }

    public synchronized void einfuegen(){
        while (true) {
            if (anzahl < max) {
                anzahl++;
                break;
            } else {
                try {
                    System.out.println("*");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        //Wenn kein Platz ist, dann wird der aktive Thread in einen Wartezustand versetzt:
        //try{wait();}catch(InterruptedException e){}
        //dazu ein Sternchen anzeigen lassen
        //Beachte: wenn ein Thread nach dem Aufwecken wieder weiter macht, muss erneut �berpr�ft werden, ob Platz ist
        
        //Wenn Platz ist, dann zuf�llige Wartezeit von bis zu 1000 ms (unten bereits implementiert)
        //anzahl inkrementieren, dann die wartenden Threads aufwecken

        try {
            Thread.sleep((int) (java.lang.Math.random()*1000));
        } catch (InterruptedException e) {}   
        notifyAll();

    }

    public synchronized void entnehmen(){
        while (true) {
            if (anzahl > 0) {
                anzahl--;
                break;
            } else {
                try {
                    System.out.println("*");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        //Wenn nichts da ist, dann wird der aktive Thread in einen Wartezustand versetzt:
        //try{wait();}catch(InterruptedException e){}
        //dazu ein Sternchen anzeigen lassen
        //Beachte: wenn ein Thread nach dem Aufwecken wieder weiter macht, muss erneut �berpr�ft werden, ob etwas da ist
        
        //Wenn etwas da ist, dann zuf�llige Wartezeit von bis zu 1000 ms (unten bereits implementiert)
        //anzahl dekrementieren, dann die wartenden Threads aufwecken

        try {
            Thread.sleep((int) (java.lang.Math.random()*1000));
        } catch (InterruptedException e) {}   
        notifyAll();
    }

}
