package com.parking.model;

public class Truck implements Vechicle {
    private int size;

    // default constructor
    public Truck() {
        this.size = 3; // по подразбиране тежък камион заема 3 слота
    }

    // constructor с параметър
    public Truck(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getType() {
        return "Truck";
    }
}
