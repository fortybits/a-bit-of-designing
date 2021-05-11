package edu.bit.designing.parking.provider;

import edu.bit.designing.parking.data.MultiStoreParking;
import edu.bit.designing.parking.data.slot.Slot;
import edu.bit.designing.parking.data.vehicle.Registration;
import edu.bit.designing.parking.entities.response.ParkingLotStatusResponse;
import edu.bit.designing.parking.entities.response.RegistrationDetailsResponse;
import edu.bit.designing.parking.entities.response.SlotDetailsResponse;
import edu.bit.designing.parking.exception.NoMatchingSlotsFoundException;
import edu.bit.designing.parking.exception.NoSuchVehicleRegisteredException;
import edu.bit.designing.parking.service.Inquiry;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InquiryProvider implements Inquiry {

    MultiStoreParking multiStoreParking;

    public InquiryProvider(MultiStoreParking multiStoreParking) {
        this.multiStoreParking = multiStoreParking;
    }

    @Override
    public ParkingLotStatusResponse parkingLotStatus() {
        List<Slot> occupiedSlots = multiStoreParking.getParkingLots()
                .stream()
                .flatMap(p -> p.getSlots().stream().filter(Slot::isOccupied))
                .collect(Collectors.toList());
        return new ParkingLotStatusResponse(occupiedSlots);
    }

    @Override
    public RegistrationDetailsResponse getRegistrationNumbersFromColor(String color) throws NoMatchingSlotsFoundException {
        final List<Slot> correspondingSlots = multiStoreParking.getParkingLots()
                .stream()
                .flatMap(p -> p.getColorToSlots().getOrDefault(color, Collections.emptyList()).stream())
                .collect(Collectors.toList());
        if (correspondingSlots.isEmpty()) {
            throw new NoMatchingSlotsFoundException("No vehicle with matching description found in parking");
        }
        final List<Registration> registrations = correspondingSlots.stream()
                .map(slot -> slot.getVehicle().getRegistration())
                .collect(Collectors.toList());
        return new RegistrationDetailsResponse(registrations);
    }

    @Override
    public SlotDetailsResponse getSlotNumbersFromColor(String color) throws NoMatchingSlotsFoundException {
        final List<Slot> correspondingSlots = multiStoreParking.getParkingLots().stream()
                .flatMap(pl -> pl.getSlots().stream())
                .collect(Collectors.toList());
        if (correspondingSlots.isEmpty()) {
            throw new NoMatchingSlotsFoundException("No vehicle with matching description found in parking");
        }
        final List<Integer> slotNumbers = correspondingSlots.stream()
                .map(Slot::getSlotNumber)
                .collect(Collectors.toList());
        return new SlotDetailsResponse(slotNumbers);
    }

    @Override
    public int getSlotNumberFromRegistrationNumber(String registrationNo) throws NoSuchVehicleRegisteredException {
        final Optional<Slot> registeredSlot = multiStoreParking.getParkingLots()
                .stream()
                .filter(pl -> pl.getRegistrationToSlot().containsKey(registrationNo))
                .map(p -> p.getRegistrationToSlot().get(registrationNo))
                .findFirst();
        if (!registeredSlot.isPresent()) {
            throw new NoSuchVehicleRegisteredException("Not found");
        }
        return registeredSlot.get().getSlotNumber();
    }
}