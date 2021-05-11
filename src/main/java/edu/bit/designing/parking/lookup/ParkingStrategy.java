package edu.bit.designing.parking.lookup;

import edu.bit.designing.parking.data.slot.Slot;

import java.util.List;
import java.util.Optional;

/**
 * Various parking providers can have different strategies, currently that would mean implementing the findAvailableSlot API.
 */
public interface ParkingStrategy {
    Optional<Slot> findAvailableSlot(List<Slot> slot);
}