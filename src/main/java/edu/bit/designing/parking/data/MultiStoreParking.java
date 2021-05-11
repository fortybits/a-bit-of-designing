package edu.bit.designing.parking.data;

import java.util.ArrayList;
import java.util.List;

public class MultiStoreParking {

    private final List<ParkingLot> parkingLots;

    public MultiStoreParking() {
        this.parkingLots = new ArrayList<>();
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}