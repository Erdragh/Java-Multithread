package com.github.erdragh.javamultithread.exercise4;

public class User extends Thread {

    private Storage storage;
    private boolean active, running;

    public User(Storage storage, boolean active) {
        this.storage = storage;
        this.active = active;
        running = true;
    }

    @Override
    public void run() {
        System.out.println("User started");
        if (active) {
            active();
        } else {
            passive();
        }
    }

    private void active() {
        while(running) {
            System.out.println("User reporting in");
            try {
                Thread.sleep((int) (500 + 2000 * Math.random()));
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            while (storage.useActive() < 0) {
                System.out.println("[USER WAITING]");
                try {
                    Thread.sleep((int) (500 + 2000 * Math.random()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void passive() {
        while (running) {
            storage.usePassive();
        }
    }
    
}