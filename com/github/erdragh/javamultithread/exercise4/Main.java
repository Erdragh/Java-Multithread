package com.github.erdragh.javamultithread.exercise4;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        boolean active = false;

        int numFactory = 1 + (int) (Math.random() * 5);
        int numUser = 1 + (int) (Math.random() * 5);

        System.out.println("New Simulation: " + storage + " " + (active ? "active" : "passive") + " NumFactory: " + numFactory + " NumUser: " + numUser);

        Factory[] factories = new Factory[numFactory];
        User[] users = new User[numUser];

        for (Factory f : factories) {
            f = new Factory(storage, active);
            f.start();
        }
        for (User u : users) {
            u = new User(storage, active);
            u.start();
        }
        // new User(storage, active).start();
        // new Factory(storage, active).start();
    }
}
