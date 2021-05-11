package edu.bit.designing.parking.data;

import edu.bit.designing.parking.data.slot.PremiumSlot;
import edu.bit.designing.parking.data.slot.Slot;
import edu.bit.designing.parking.lookup.ParkingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParkingLot {
    private final List<Slot> slots;
    // should we maintain these?
    private final Map<Integer, Slot> findSlotById;
    private final Map<String, Slot> registrationToSlot;
    private final Map<String, List<Slot>> colorToSlots;
    int lotId;
    ParkingStrategy parkingStrategy;

    public ParkingLot(int lotId, List<Slot> slots, Map<Integer, Slot> slotById, ParkingStrategy parkingStrategy) {
        this.lotId = lotId;
        this.slots = slots;
        this.parkingStrategy = parkingStrategy;
        this.findSlotById = slotById;
        this.registrationToSlot = new HashMap<>();
        this.colorToSlots = new HashMap<>();
    }

    // Currently assuming all slots to be of same type (for Cars - Premium) based on the inputs
    public static ParkingLot initialiseParkingLotWithSlots(int lotId, int capacity, ParkingStrategy parkingStrategy) {
        List<Slot> slots = IntStream.rangeClosed(1, capacity)
                .mapToObj(PremiumSlot::new)
                .collect(Collectors.toList());
        Map<Integer, Slot> slotById = slots.stream()
                .collect(Collectors.toMap(Slot::getSlotNumber, Function.identity()));
        return new ParkingLot(lotId, slots, slotById, parkingStrategy);
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public int proximity() {
        return lotId;
    }

    public boolean isCapacityAvailable() {
        return slots.stream().anyMatch(s -> !s.isOccupied());
    }

    public long availableCapacity() {
        return slots.stream().filter(s -> !s.isOccupied()).count();
    }

    public ParkingStrategy getParkingStrategy() {
        return parkingStrategy;
    }

    public void modifyColorToSlots(String color, Slot slot, boolean register) {
        colorToSlots.computeIfAbsent(color, k -> new ArrayList<>());
        if (register) {
            colorToSlots.get(color).add(slot);
        } else {
            colorToSlots.get(color).remove(slot);
        }
    }

    public void modifyRegistrationToSlots(String registrationNumber, Slot slot, boolean register) {
        if (register) {
            registrationToSlot.put(registrationNumber, slot);
        } else {
            registrationToSlot.remove(registrationNumber, slot);
        }
    }

    public Map<String, Slot> getRegistrationToSlot() {
        return registrationToSlot;
    }

    public Map<String, List<Slot>> getColorToSlots() {
        return colorToSlots;
    }

    public Map<Integer, Slot> slotLookUp() {
        return findSlotById;
    }
}