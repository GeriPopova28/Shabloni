package com.parking.model;

public class Motocycle implements Vechicle {
    private int size;

    // default constructor
    public Motocycle() {
        this.size = 1;
    }

    // constructor с параметър
    public Motocycle(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getType() {
        return "Motorcycle";
    }
}
