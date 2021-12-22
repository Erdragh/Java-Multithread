package com.github.erdragh.javamultithread.exercise2;

public class Main {
        // Attribute


    // Konstruktor
    public static void main(String args[])
    {

        Speicher spe = new Speicher(5,1);
        
        Erzeuger erz1 = new Erzeuger("E1", spe, 2000);
        Verbraucher ver1 = new Verbraucher("V1", spe, 4000);
        Erzeuger erz2 = new Erzeuger("E2", spe, 2000);
        Verbraucher ver2 = new Verbraucher("V2", spe, 4000);
        
        erz1.start();
        ver1.start();
        erz2.start();
        ver2.start();

    }


    // Methoden

}
