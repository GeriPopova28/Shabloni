package com.parking.singleton;


import com.parking.model.ParkingSlot;
import com.parking.model.Vechicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot instance;

    private List<ParkingSlot> slots;

    private ParkingLot(int capacity) {
        slots = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            slots.add(new ParkingSlot());
        }
    }

    public static synchronized ParkingLot getInstance(int capacity) {
        if (instance == null) {
            instance = new ParkingLot(capacity);
        }
        return instance;
    }

    public synchronized boolean parkVehicle(Vechicle vehicle) {
        int needed = vehicle.getSize();
        int freeCount = (int) slots.stream().filter(s -> !s.isOccupied()).count();

        if (freeCount < needed) return false;

        int parked = 0;
        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied() && parked < needed) {
                slot.occupy();
                parked++;
            }
        }
        return true;
    }

    public synchronized void removeVehicle(Vechicle vehicle) {
        int needed = vehicle.getSize();
        int freed = 0;
        for (ParkingSlot slot : slots) {
            if (slot.isOccupied() && freed < needed) {
                slot.free();
                freed++;
            }
        }
    }

    public void start() {
        System.out.println("ParkingLot стартира!");
        System.out.println("Общо слотове: " + getTotalSlots());
        System.out.println("Свободни слотове: " + getFreeSlots());
    }


    public int getFreeSlots() {
        return (int) slots.stream().filter(s -> !s.isOccupied()).count();
    }

    public int getTotalSlots() {
        return slots.size();
    }

}
