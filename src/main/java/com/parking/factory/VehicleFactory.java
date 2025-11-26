package com.parking.factory;

import com.parking.model.*;

public class VehicleFactory {
    public static Vehicle createVehicle(String type, String plate) {
        switch(type.toLowerCase()) {
            case "car": return new Car(plate);
            case "motorcycle": return new Motocycle(plate);
            case "truck": return new Truck(plate);
            default: throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}
