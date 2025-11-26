package com.parking.singleton;

import com.parking.model.Vehicle;
import com.parking.observer.Observer;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ParkingLot {

    private final int capacity = 10;
    private final List<Vehicle> parkedVehicles = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();

    // Observer методи
    public void addObserver(Observer o) { observers.add(o); }
    public void removeObserver(Observer o) { observers.remove(o); }

    private void notifyObservers() {
        for (Observer o : observers) o.update(parkedVehicles);
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (parkedVehicles.size() >= capacity) return false;
        parkedVehicles.add(vehicle);
        notifyObservers();
        return true;
    }

    public double removeVehicleByPlate(String licensePlate) {
        for (Vehicle v : parkedVehicles) {
            if (v.getLicensePlate().equals(licensePlate)) {
                parkedVehicles.remove(v);
                notifyObservers();
                return 5.0;
            }
        }
        return 0;
    }

    public int getCapacity() { return capacity; }
    public int getFreeSpace() { return capacity - parkedVehicles.size(); }
    public List<Vehicle> getParkedVehicles() { return parkedVehicles; }
}
