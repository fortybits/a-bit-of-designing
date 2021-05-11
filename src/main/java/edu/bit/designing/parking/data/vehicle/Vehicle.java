package edu.bit.designing.parking.data.vehicle;

public abstract class Vehicle {
    Registration registration;
    Description description;
    VehicleType vehicleType;

    public Vehicle(Registration registration, Description description, VehicleType vehicleType) {
        this.registration = registration;
        this.description = description;
        this.vehicleType = vehicleType;
    }

    public Registration getRegistration() {
        return registration;
    }

    public Description getDescription() {
        return description;
    }
}