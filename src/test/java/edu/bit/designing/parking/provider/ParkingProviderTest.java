package edu.bit.designing.parking.provider;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParkingProviderTest {

    edu.bit.designing.parking.service.Parking parking;
    edu.bit.designing.parking.data.MultiStoreParking multiStoreParking;

    @BeforeEach
    void setup() {
        multiStoreParking = new edu.bit.designing.parking.data.MultiStoreParking();
        parking = new ParkingProvider(multiStoreParking);
    }

    @Test
    void createParkingLot() throws edu.bit.designing.parking.exception.InvalidParkingCapacityException {
        final int parkingCapacity = 10;
        final edu.bit.designing.parking.entities.request.CreateParkingRequest createParkingRequest = new edu.bit.designing.parking.entities.request.CreateParkingRequest(parkingCapacity);
        edu.bit.designing.parking.entities.response.CreateParkingResponse parkingLot = parking.createParkingLot(createParkingRequest);
        Assertions.assertEquals(parkingCapacity, parkingLot.getCapacity());
    }

    @Test
    void parkVehicleShouldThrowExceptionWithoutParkingCapacity() {
        final edu.bit.designing.parking.data.vehicle.Vehicle vehicle = new edu.bit.designing.parking.data.vehicle.Bike(new edu.bit.designing.parking.data.vehicle.Registration("KA-51-JE-BIKE"), new edu.bit.designing.parking.data.vehicle.Description("Red"));
        edu.bit.designing.parking.entities.request.ParkingRequest parkingRequest = new edu.bit.designing.parking.entities.request.ParkingRequest(vehicle);
        Assertions.assertThrows(edu.bit.designing.parking.exception.ParkingSpaceNotAvailableException.class,
                () -> parking.parkVehicle(parkingRequest));
    }

    @Test
    void leaveParking() {
    }

}