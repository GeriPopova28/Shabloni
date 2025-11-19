package com.parking;

import com.parking.singleton.ParkingLot;
import com.parking.model.Vechicle;
import com.parking.model.Car;
import com.parking.model.Motocycle;
import com.parking.model.Truck;

public class Main {
    public static void main(String[] args) {
        int capacity = 10;
        ParkingLot lot = ParkingLot.getInstance(capacity);

        // Стартираме паркинга
        lot.start();

        // Създаваме различни превозни средства
        Vechicle car1 = new Car(1);
        Vechicle bike1 = new Motocycle(1);
        Vechicle truck1 = new Truck(3); // заема 3 слота

        // Паркираме превозните средства
        if (lot.parkVehicle(car1)) System.out.println("Car е паркиран!");
        if (lot.parkVehicle(bike1)) System.out.println("Motorcycle е паркиран!");
        if (lot.parkVehicle(truck1)) System.out.println("Truck е паркиран!");

        // Проверяваме свободните слотове
        System.out.println("Свободни слотове: " + lot.getFreeSlots());
    }
}
