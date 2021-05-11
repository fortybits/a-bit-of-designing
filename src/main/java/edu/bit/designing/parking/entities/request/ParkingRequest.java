package edu.bit.designing.parking.entities.request;

import edu.bit.designing.parking.data.vehicle.Vehicle;

public class ParkingRequest {
    Vehicle vehicle;


    public ParkingRequest(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}