package com.parking.model;

public class ParkingSlot {
    private boolean occupied = false;

    public boolean isOccupied() {
        return occupied;
    }

    public void occupy() {
        occupied = true;
    }

    public void free() {
        occupied = false;
    }
}

