package com.parking.observer;

import com.parking.model.Vehicle;
import java.util.List;

public interface Observer {
    void update(List<Vehicle> vehicles);
}
