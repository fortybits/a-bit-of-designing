package edu.bit.designing.parking.dispatch;

import edu.bit.designing.parking.data.MultiStoreParking;
import edu.bit.designing.parking.data.ParkingLot;

import java.util.Comparator;
import java.util.Optional;

public class EvenDistributionDispatcher implements Dispatcher {

    MultiStoreParking multiStoreParking;

    public EvenDistributionDispatcher(MultiStoreParking multiStoreParking) {
        this.multiStoreParking = multiStoreParking;
    }

    @Override
    public Optional<ParkingLot> findParkingLot() {
        return multiStoreParking.getParkingLots()
                .stream()
                .max(Comparator.comparingLong(ParkingLot::availableCapacity));
    }

}