package com.parking.observer;

import com.parking.model.Vehicle;
import java.util.List;

public class ConsoleDisplay implements Observer {
    @Override
    public void update(List<Vehicle> vehicles) {
        System.out.println("Parking lot updated! Current vehicles:");
        for (Vehicle v : vehicles) {
            System.out.println(v.getLicensePlate() + " (" + v.getType() + ")");
        }
        System.out.println("Total vehicles: " + vehicles.size());
    }
}
