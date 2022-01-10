package com.github.erdragh.javamultithread.exercise3;

// Klasse MainA
public class MainA{
    
    public static void main(String args[]){

        SpeicherA s = new SpeicherA(5,1);
        
        ErzeugerA erz1 = new ErzeugerA("E1", s, 3000);
        VerbraucherA ver1 = new VerbraucherA("V1", s, 5000);
        ErzeugerA erz2 = new ErzeugerA("E2", s, 3000);
        VerbraucherA ver2 = new VerbraucherA("V2", s, 5000);
        
        erz1.start();
        ver1.start();
        erz2.start();
        ver2.start();
    }

}
