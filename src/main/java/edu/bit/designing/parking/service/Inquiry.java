package edu.bit.designing.parking.service;

import edu.bit.designing.parking.entities.response.ParkingLotStatusResponse;
import edu.bit.designing.parking.entities.response.RegistrationDetailsResponse;
import edu.bit.designing.parking.entities.response.SlotDetailsResponse;
import edu.bit.designing.parking.exception.NoMatchingSlotsFoundException;
import edu.bit.designing.parking.exception.NoSuchVehicleRegisteredException;

/**
 * Inquiry as a service is to mostly read data from the application, specifically designed for the details
 * required by the government regulation to have a clear separation from parking APIs.
 * The separation also makes sense in order to adapt to a flexible requirement of reading a snapshot of actual
 * data in real applications.
 */
public interface Inquiry {

    ParkingLotStatusResponse parkingLotStatus();

    RegistrationDetailsResponse getRegistrationNumbersFromColor(String color) throws NoMatchingSlotsFoundException;

    SlotDetailsResponse getSlotNumbersFromColor(String color) throws NoMatchingSlotsFoundException;

    int getSlotNumberFromRegistrationNumber(String registrationNo) throws NoSuchVehicleRegisteredException;
}