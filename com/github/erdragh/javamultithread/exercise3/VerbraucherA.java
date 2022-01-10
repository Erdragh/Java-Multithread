package com.github.erdragh.javamultithread.exercise3;

// Klasse VerbraucherA
public class VerbraucherA extends Thread{
    
    // Attribute
    private SpeicherA speicher;
    private int verarbeitungszeit;
    private String name;

    // Konstruktor
    public VerbraucherA(String _name, SpeicherA _speicher, int _verarbeitungszeit){
        name = _name;
        speicher = _speicher;
        verarbeitungszeit = _verarbeitungszeit;
    }

    // Methoden
    public void run(){
        while(true){
            warten(verarbeitungszeit);

            System.out.println("                                        entnehmen("+name+")");            

            while (!speicher.entnehmen()) {
                warten(500);
                System.out.println("                                        *");
            }
            //beim Speicher immer wieder die Entnehmen-Methode aufrufen, bis sie einmal erfolgreich war
            //zwischen den Versuchen jedes Mal kurz warten (500ms) und ein Sternchen anzeigen lassen

            System.out.println("                                        "+speicher.getAnzahl());               
        }
    }

    public void warten(int ms){
        try {
            Thread.sleep((int) (java.lang.Math.random()*ms));
        } catch (InterruptedException e) {} 
    }

}
