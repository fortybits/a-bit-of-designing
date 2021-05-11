package edu.bit.designing.parking.lookup;

import edu.bit.designing.parking.data.slot.Slot;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Implements the parking strategy with a proximity of the slot coordinates. e.g. distance from entry in our case
 */
public class NearestAvailableSlot implements ParkingStrategy {

    @Override
    public Optional<Slot> findAvailableSlot(List<Slot> slotList) {
        return slotList.stream()
                .filter(s -> !s.isOccupied())
                .min(Comparator.comparing(s -> s.getCoordinates().proximity()));
    }
}