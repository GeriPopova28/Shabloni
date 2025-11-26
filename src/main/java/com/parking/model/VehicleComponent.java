package com.parking.model;

import java.util.List;

public interface VehicleComponent {
    int getSize();
    String getType();
    double getPricePerHour();
    String getLicensePlate();  // за единични превозни средства, групите могат да върнат "GROUP"
    List<VehicleComponent> getComponents();
}
