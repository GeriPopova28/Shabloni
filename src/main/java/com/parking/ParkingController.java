package com.parking;

import com.parking.factory.VehicleFactory;
import com.parking.model.Vehicle;
import com.parking.singleton.ParkingLot;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ParkingController {

    private final ParkingLot parkingLot;

    public ParkingController(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("vehicles", parkingLot.getParkedVehicles());
        model.addAttribute("free", parkingLot.getFreeSpace());
        model.addAttribute("total", parkingLot.getCapacity());
        return "index"; // index.html в templates/
    }

    @PostMapping("/park")
    public String park(@RequestParam String type, @RequestParam String licensePlate, Model model) {
        Vehicle vehicle = VehicleFactory.createVehicle(type, licensePlate);
        boolean success = parkingLot.parkVehicle(vehicle);
        model.addAttribute("message", success ? "Vehicle parked successfully!" : "Not enough space!");
        model.addAttribute("vehicles", parkingLot.getParkedVehicles());
        model.addAttribute("free", parkingLot.getFreeSpace());
        model.addAttribute("total", parkingLot.getCapacity());
        return "index";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam String licensePlate, Model model) {
        double fee = parkingLot.removeVehicleByPlate(licensePlate);
        model.addAttribute("message", fee > 0 ? "Vehicle removed. Fee: $" + fee : "Vehicle not found!");
        model.addAttribute("vehicles", parkingLot.getParkedVehicles());
        model.addAttribute("free", parkingLot.getFreeSpace());
        model.addAttribute("total", parkingLot.getCapacity());
        return "index";
    }
}
