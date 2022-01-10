package com.github.erdragh.javamultithread.exercise3;

// Klasse VerbraucherP
public class VerbraucherP extends Thread{

    // Attribute
    private SpeicherP speicher;
    private int verarbeitungszeit;
    private String name;

    // Konstruktor
    public VerbraucherP(String _name, SpeicherP _speicher, int _verarbeitungszeit){
        name = _name;
        speicher = _speicher;
        verarbeitungszeit = _verarbeitungszeit;
    }

    // Methoden
    public void run(){
        while(true){
            warten(verarbeitungszeit);

            System.out.println("                                        entnehmen("+name+")");            

            speicher.entnehmen();

            System.out.println("                                        "+speicher.getAnzahl());               
        }
    }

    public void warten(int ms){
        try {
            Thread.sleep((int) (java.lang.Math.random()*ms));
        } catch (InterruptedException e) {} 
    }

}
