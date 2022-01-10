package com.github.erdragh.javamultithread.exercise3;

// Klasse ErzeugerP
public class ErzeugerP extends Thread{

    // Attribute
    private SpeicherP speicher;
    private int verarbeitungszeit;
    private String name;

    // Konstruktor
    public ErzeugerP(String _name, SpeicherP _speicher, int _verarbeitungszeit){
        name = _name;
        speicher = _speicher;
        verarbeitungszeit = _verarbeitungszeit;
    }

    // Methoden
    public void run(){
        while(true){
            warten(verarbeitungszeit);

            System.out.println("einf�gen("+name+")");            

            speicher.einfuegen();

            System.out.println(speicher.getAnzahl());               
        }
    }

    public void warten(int ms){
        try {
            Thread.sleep((int) (java.lang.Math.random()*ms));
        } catch (InterruptedException e) {} 
    }

}
