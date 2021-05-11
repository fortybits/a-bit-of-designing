package edu.bit.designing.parking.entities.response;

import edu.bit.designing.parking.data.slot.Slot;

import java.util.List;
import java.util.stream.Collectors;

public class ParkingLotStatusResponse {
    List<Slot> occupiedSlots;

    public ParkingLotStatusResponse(List<Slot> occupiedSlots) {
        this.occupiedSlots = occupiedSlots;
    }

    @Override
    public String toString() {
        String format = String.format("%-10s  %-15s  %-15s\n", "Slot No.", "Registration No", "Colour");
        String slotsInfo = occupiedSlots.stream()
                .map(slot -> String.format("%-10d  %-15s  %-15s", slot.getSlotNumber(),
                        slot.getVehicle().getRegistration(), slot.getVehicle().getDescription()))
                .collect(Collectors.joining("\n"));
        return slotsInfo.isEmpty() ? "No vehicles parked" : format + slotsInfo;
    }
}