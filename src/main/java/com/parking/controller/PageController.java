package com.parking.controller;

import com.parking.factory.VehicleFactory;
import com.parking.model.Vehicle;
import com.parking.singleton.ParkingLot;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    private final ParkingLot parkingLot;

    public PageController(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("vehicles", parkingLot.getParkedVehicles());
        model.addAttribute("free", parkingLot.getFreeSpace());
        model.addAttribute("total", parkingLot.getCapacity());
        return "index"; // index.html
    }

    // Тук слагаш POST методите, които ми прати
    @PostMapping("/park")
    public String parkVehicle(@RequestParam String licensePlate,
                              @RequestParam String type,
                              Model model) {
        Vehicle vehicle = VehicleFactory.createVehicle(type, licensePlate);
        parkingLot.parkVehicle(vehicle);

        model.addAttribute("vehicles", parkingLot.getParkedVehicles());
        model.addAttribute("free", parkingLot.getFreeSpace());
        model.addAttribute("total", parkingLot.getCapacity());
        model.addAttribute("message", licensePlate + " parked successfully!");
        return "index";
    }

    @PostMapping("/remove")
    public String removeVehicle(@RequestParam String licensePlate, Model model) {
        double fee = parkingLot.removeVehicleByPlate(licensePlate);

        model.addAttribute("vehicles", parkingLot.getParkedVehicles());
        model.addAttribute("free", parkingLot.getFreeSpace());
        model.addAttribute("total", parkingLot.getCapacity());
        model.addAttribute("message", licensePlate + " removed. Fee: $" + fee);
        return "index";
    }
}
