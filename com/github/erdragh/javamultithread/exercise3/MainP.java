package com.github.erdragh.javamultithread.exercise3;

// Klasse MainP
public class MainP{
    
    public static void main(String args[]){

        SpeicherP s = new SpeicherP(5,1);
        
        ErzeugerP erz1 = new ErzeugerP("E1", s, 3000);
        VerbraucherP ver1 = new VerbraucherP("V1", s, 5000);
        ErzeugerP erz2 = new ErzeugerP("E2", s, 3000);
        VerbraucherP ver2 = new VerbraucherP("V2", s, 5000);
        
        erz1.start();
        ver1.start();
        erz2.start();
        ver2.start();
    }

}
