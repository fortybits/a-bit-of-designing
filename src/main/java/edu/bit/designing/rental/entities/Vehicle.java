package edu.bit.designing.rental.entities;

import lombok.Getter;

@Getter
public class Vehicle {
    VehicleType vehicleType;
    Rate rate;

    public enum VehicleType {
        CAR, BIKE
    }

    @Getter
    class Rate {
        int pricePerHour;
    }
}