package com.parking.model;

import java.util.ArrayList;
import java.util.List;

public class VehicleGroup extends Vehicle {
    private List<Vehicle> vehicles = new ArrayList<>();

    public VehicleGroup(String groupName) {
        super(groupName, "Group");
    }

    public void add(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
