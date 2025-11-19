package com.example.util;

public class ParkingAlert implements ParkingObserver {
    @Override
    public void notifyFull() {
        System.out.println("Alert: Parking lot is full!");
    }
}
