package edu.bit.designing.parking.data.vehicle;

public class Bike extends Vehicle {

    public Bike(Registration registration, Description color) {
        super(registration, color, VehicleType.TWO_WHEELER);
    }
}
