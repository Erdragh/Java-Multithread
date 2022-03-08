package com.github.erdragh.javamultithread.exercise4;

public class Factory extends Thread {

    private Storage storage;
    private boolean active, running;

    public Factory(Storage storage, boolean active) {
        this.storage = storage;
        this.active = active;
        running = true;
    }

    @Override
    public void run() {
        if (active) {
            active();
        } else {
            passive();
        }
    }

    private void active() {
        while(running) {
            try {
                Thread.sleep((int) (500 + 2000 * Math.random()));
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            while (!storage.storeActive()) {
                System.out.println("[FACTORY WAITING]");
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
            storage.storePassive();
        }
    }
    
}
