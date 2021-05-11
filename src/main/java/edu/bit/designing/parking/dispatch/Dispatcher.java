package edu.bit.designing.parking.dispatch;

import edu.bit.designing.parking.data.ParkingLot;

import java.util.Optional;

public interface Dispatcher {

    Optional<ParkingLot> findParkingLot();
}