package com.github.erdragh.javamultithread.exercise1;

public class Simulation {
    public static void main(String[] args) {
        //Z&uuml;ge erzeugen
        Zug[] zuege = new Zug[2];
        zuege[0] = new Zug("ICE",180);
        zuege[1] = new Zug("Bus",0);
        //Kunden erzeugen...
        Kunde t1 = new Kunde("Kunde 1", zuege);
        Kunde t2 = new Kunde("Kunde 2", zuege);
        //Kunden fragen an und reservieren....
        t1.start(); 
        t2.start();
    }
}
