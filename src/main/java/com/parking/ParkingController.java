package com.parking;

import com.parking.model.Car;
import com.parking.model.Motocycle;
import com.parking.model.Truck;
import com.parking.model.Vechicle;
import com.parking.singleton.ParkingLot;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking")

public class ParkingController {
    private final ParkingLot parkingLot = ParkingLot.getInstance(10); // 10 места

    @GetMapping("/status")
    public String getStatus() {
        return "Free slots: " + parkingLot.getFreeSlots() + "/" + parkingLot.getTotalSlots();
    }

    @PostMapping("/park")
    public String park(@RequestParam String type) {
        Vechicle vehicle;

        switch (type.toLowerCase()) {
            case "car":
                vehicle = new Car();
                break;
            case "motorcycle":
                vehicle = new Motocycle();
                break;
            case "truck":
                vehicle = new Truck();
                break;
            default:
                return "Unknown vehicle type";
        }
        boolean success = parkingLot.parkVehicle(vehicle);
        return success ? type + " parked!" : "Not enough space for " + type;
    }

    @PostMapping("/remove")
    public String remove(@RequestParam String type) {
        Vechicle vehicle;
        switch (type.toLowerCase()) {
            case "car": vehicle = new Car(); break;
            case "motorcycle": vehicle = new Motocycle(); break;
            case "truck": vehicle = new Truck(); break;
            default: return "Unknown vehicle type";
        }

        parkingLot.removeVehicle(vehicle);
        return type + " removed!";
    }
}
