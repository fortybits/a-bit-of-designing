package edu.bit.designing.parking.data.vehicle;

public class Car extends Vehicle {

    public Car(Registration registration, Description color) {
        super(registration, color, VehicleType.FOUR_WHEELER);
    }
}