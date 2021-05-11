package edu.bit.designing.parking.provider;

import edu.bit.designing.parking.data.MultiStoreParking;
import edu.bit.designing.parking.data.ParkingLot;
import edu.bit.designing.parking.data.slot.Slot;
import edu.bit.designing.parking.data.vehicle.Vehicle;
import edu.bit.designing.parking.dispatch.Dispatcher;
import edu.bit.designing.parking.dispatch.DispatcherType;
import edu.bit.designing.parking.dispatch.EvenDistributionDispatcher;
import edu.bit.designing.parking.dispatch.FillFirstDispatcher;
import edu.bit.designing.parking.entities.request.CreateParkingRequest;
import edu.bit.designing.parking.entities.request.LeaveParkingRequest;
import edu.bit.designing.parking.entities.request.ParkingRequest;
import edu.bit.designing.parking.entities.response.CreateParkingResponse;
import edu.bit.designing.parking.entities.response.LeaveParkingResponse;
import edu.bit.designing.parking.entities.response.ParkingResponse;
import edu.bit.designing.parking.exception.InvalidParkingCapacityException;
import edu.bit.designing.parking.exception.NoSuchSlotExistException;
import edu.bit.designing.parking.exception.ParkingSpaceNotAvailableException;
import edu.bit.designing.parking.lookup.NearestAvailableSlot;
import edu.bit.designing.parking.service.Parking;

import java.util.List;
import java.util.Optional;

public class ParkingProvider implements Parking {

    Dispatcher dispatcher;
    MultiStoreParking multiStoreParking;

    public ParkingProvider(MultiStoreParking multiStoreParking) {
        this.dispatcher = new FillFirstDispatcher(multiStoreParking);
        this.multiStoreParking = multiStoreParking;
    }

    @Override
    public CreateParkingResponse createParkingLot(CreateParkingRequest createRequest) throws InvalidParkingCapacityException {
        if (createRequest.getCapacity() < 1) {
            throw new InvalidParkingCapacityException("Parking capacity should be greater than 0.");
        }
        ParkingLot parkingLot = ParkingLot.initialiseParkingLotWithSlots(createRequest.getLotId(), createRequest.getCapacity(), new NearestAvailableSlot());
        multiStoreParking.getParkingLots().add(parkingLot);
        return new CreateParkingResponse(createRequest.getCapacity());
    }

    @Override
    public ParkingResponse parkVehicle(ParkingRequest parkingRequest)
            throws ParkingSpaceNotAvailableException {
        Optional<ParkingLot> optionalParkingLot = dispatcher.findParkingLot();
        if (!optionalParkingLot.isPresent()) {
            throw new ParkingSpaceNotAvailableException("No parking lot is available!");
        } else {
            ParkingLot lot = optionalParkingLot.get();
            List<Slot> parkingSlots = lot.getSlots();
            if (parkingSlots.isEmpty()) {
                throw new ParkingSpaceNotAvailableException("No parking slots created!");
            }
            Optional<Slot> nearestSlot = optionalParkingLot.get().getParkingStrategy().findAvailableSlot(parkingSlots);
            if (nearestSlot.isPresent()) {
                Slot slot = nearestSlot.get();
                final Vehicle vehicle = parkingRequest.getVehicle();
                slot.modifySlot(vehicle);

                final String registrationNumber = vehicle.getRegistration().getRegistrationNumber();
                lot.modifyRegistrationToSlots(registrationNumber, slot, true);

                final String color = vehicle.getDescription().getColor();
                lot.modifyColorToSlots(color, slot, true);

                return new ParkingResponse(slot.getCoordinates());
            } else {
                throw new ParkingSpaceNotAvailableException("Sorry, parking lot is full");
            }
        }
    }

    @Override
    public LeaveParkingResponse leaveParking(LeaveParkingRequest leaveParkingRequest) throws NoSuchSlotExistException {
        int slotNumber = leaveParkingRequest.getSlotNumber();
        ParkingLot parkingLot = multiStoreParking.getParkingLots().get(leaveParkingRequest.getParkingLot());
        Slot slot = parkingLot.slotLookUp().get(slotNumber);
        if (slot == null || slot.getVehicle() == null) {
            throw new NoSuchSlotExistException("Invalid slot number provided while leaving");
        }
        final Vehicle vehicle = slot.getVehicle();
        final String registrationNumber = vehicle.getRegistration().getRegistrationNumber();
        parkingLot.modifyRegistrationToSlots(registrationNumber, slot, false);

        final String color = vehicle.getDescription().getColor();
        parkingLot.modifyColorToSlots(color, slot, false);

        slot.modifySlot(null);
        return new LeaveParkingResponse(slotNumber);
    }

    @Override
    public void modifyDispatcher(DispatcherType dispatcherType) {
        switch (dispatcherType) {
            case FILL_FIRST:
                dispatcher = new FillFirstDispatcher(multiStoreParking);
                break;
            case EVEN_DISTRIBUTION:
                dispatcher = new EvenDistributionDispatcher(multiStoreParking);
                break;
            default:
                throw new IllegalArgumentException("Unidentified dispatcher type!");
        }
    }
}