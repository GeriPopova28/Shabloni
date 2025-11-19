package com.parking.model;

import java.util.ArrayList;
import java.util.List;

public class VechicleGroup implements Vechicle {
    private List<Vechicle> vehicles = new ArrayList<>();

    public void addVehicle(Vechicle v) {
        vehicles.add(v);
    }

    public void removeVehicle(Vechicle v) {
        vehicles.remove(v);
    }

    @Override
    public int getSize() {
        return vehicles.stream().mapToInt(Vechicle::getSize).sum();
    }

    @Override
    public String getType() {
        return "Group of Vehicles";
    }
}