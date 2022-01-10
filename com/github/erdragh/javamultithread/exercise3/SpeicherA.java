package com.github.erdragh.javamultithread.exercise3;

// Klasse SpeicherA
public class SpeicherA{

    // Attribute
    private int anzahl, max;

    // Konstruktor
    public SpeicherA(int _max, int anzahlStart)
    {
        anzahl = anzahlStart;
        max = _max;
    }

    // Methoden
    public int getAnzahl(){
        return anzahl;
    }

    public synchronized boolean einfuegen(){
        if (anzahl < max) {
            try {
                Thread.sleep((int) (java.lang.Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            anzahl++;
            return true;
        } else {
            return false;
        }
        //falls kein Platz, dann false
        //andernfalls:
        //zuf�llige Wartezeit von bis zu 1000ms
        //anzahl inkrementieren, dann true
    }

    public synchronized boolean entnehmen(){
        if (anzahl > 0) {
            try {
                Thread.sleep((int) (java.lang.Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            anzahl--;
            return true;
        } else {
            return false;
        }
        //falls nichts da, dann false
        //andernfalls:
        //zuf�llige Wartezeit von bis zu 1000ms
        //anzahl dekrementieren, dann true
    }

}
