package edu.bit.designing.parking.dispatch;

import edu.bit.designing.parking.data.MultiStoreParking;
import edu.bit.designing.parking.data.ParkingLot;

import java.util.Comparator;
import java.util.Optional;

public class FillFirstDispatcher implements Dispatcher {

    MultiStoreParking multiStoreParking;

    public FillFirstDispatcher(MultiStoreParking multiStoreParking) {
        this.multiStoreParking = multiStoreParking;
    }

    @Override
    public Optional<ParkingLot> findParkingLot() {
        return multiStoreParking.getParkingLots()
                .stream()
                .filter(ParkingLot::isCapacityAvailable)
                .min(Comparator.comparing(ParkingLot::proximity));
    }

}