package com.parking.model;

public class Car implements Vechicle {
    private int size;

    // default constructor
    public Car() {
        this.size = 1;
    }

    // constructor с параметър
    public Car(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getType() {
        return "Car";
    }
}
