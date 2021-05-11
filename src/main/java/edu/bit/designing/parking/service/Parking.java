package edu.bit.designing.parking.service;

import edu.bit.designing.parking.dispatch.DispatcherType;
import edu.bit.designing.parking.entities.request.CreateParkingRequest;
import edu.bit.designing.parking.entities.request.LeaveParkingRequest;
import edu.bit.designing.parking.entities.request.ParkingRequest;
import edu.bit.designing.parking.entities.response.CreateParkingResponse;
import edu.bit.designing.parking.entities.response.LeaveParkingResponse;
import edu.bit.designing.parking.entities.response.ParkingResponse;
import edu.bit.designing.parking.exception.InvalidParkingCapacityException;
import edu.bit.designing.parking.exception.NoSuchSlotExistException;
import edu.bit.designing.parking.exception.ParkingSpaceNotAvailableException;

/**
 * Parking service is responsible for all the mutates on the data stores  -
 * - creating a parking lot
 * - parking a vehicle
 * - removing a vehicle from parking
 * Underlying implementation of these updates ensures that the data read via other APIs is readily available.
 * <p>
 * Since the modification is currently processed in a sequential manner, the atomicity is assumed in such modifications.
 */
public interface Parking {

    // assumption: datatype chosen for the capacity should be sufficient for input provided and is guarded by validations e.g. parseInt
    CreateParkingResponse createParkingLot(CreateParkingRequest createParkingRequest) throws InvalidParkingCapacityException;

    ParkingResponse parkVehicle(ParkingRequest parkingRequest) throws ParkingSpaceNotAvailableException;

    LeaveParkingResponse leaveParking(LeaveParkingRequest leaveParkingRequest) throws NoSuchSlotExistException;

    void modifyDispatcher(DispatcherType dispatcherType);
}