package com.github.erdragh.javamultithread.exercise4;

public class Storage {
    private int storage, max = 5;

    public synchronized boolean storeActive() {
        System.out.print("Trying to store (active): ");
        if (storage < max) {
            storage++;
            System.out.println("[SUCCESS] new storage count: " + storage);
            return true;
        } else {
            System.out.println("[ERROR] current storage count: " + storage);
            return false;
        }
    }

    public synchronized int useActive() {
        System.out.print("Trying to use (active): ");
        if (storage > 0) {
            storage--;
            System.out.println("[SUCCESS] new storage count: " + storage);
            return storage;
        } else {
            System.out.println("[ERROR] current storage count: " + storage);
            return -1;
        }
    }

    public synchronized void storePassive() {
        System.out.print("Trying to store (passive): ");
        while (storage >= max) {
            System.out.println("[ERROR] (storing) current storage count: " + storage + "; going to sleep");
            try {
                wait();
                System.out.println("Storing awakened");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage++;
        System.out.println("[SUCCESS] (storing) new storage count: " + storage + "; waking others");
        notifyAll();
    }

    public synchronized void usePassive() {
        System.out.print("Trying to use (passive): ");
        while (storage <= 0) {
            System.out.println("[ERROR] (using) current storage count: " + storage + "; going to sleep");
            try {
                wait();
                System.out.println("Using awakened");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage--;
        System.out.println("[SUCCESS] (using) new storage count: " + storage + "; waking others");
        notifyAll();
    }

    @Override
    public String toString() {
        return "[Storage: current: " + storage + " max: " + max + "]";
    }
}
