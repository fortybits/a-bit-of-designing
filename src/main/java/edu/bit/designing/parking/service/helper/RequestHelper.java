package edu.bit.designing.parking.service.helper;

import edu.bit.designing.parking.data.vehicle.Car;
import edu.bit.designing.parking.data.vehicle.Description;
import edu.bit.designing.parking.data.vehicle.Registration;
import edu.bit.designing.parking.entities.request.CreateParkingRequest;
import edu.bit.designing.parking.entities.request.LeaveParkingRequest;
import edu.bit.designing.parking.entities.request.ParkingRequest;

public class RequestHelper {

    public static CreateParkingRequest constructCreateParkingRequest(String capacity) {
        return new CreateParkingRequest(Integer.parseInt(capacity));
    }

    // improvement: can accept the type params and further details to construct anny vehicle
    public static ParkingRequest constructParkingRequest(String registrationNumber, String color) {
        return new ParkingRequest(new Car(new Registration(registrationNumber), new Description(color)));
    }

    public static LeaveParkingRequest constructLeaveParkingRequest(String slotNumber) {
        return new LeaveParkingRequest(Integer.parseInt(slotNumber));
    }
}