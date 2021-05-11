package edu.bit.designing.parking.command;

import edu.bit.designing.parking.dispatch.DispatcherType;
import edu.bit.designing.parking.entities.request.CreateParkingRequest;
import edu.bit.designing.parking.entities.request.LeaveParkingRequest;
import edu.bit.designing.parking.entities.request.ParkingRequest;
import edu.bit.designing.parking.entities.response.*;
import edu.bit.designing.parking.exception.BaseParkingException;
import edu.bit.designing.parking.service.Inquiry;
import edu.bit.designing.parking.service.Parking;
import edu.bit.designing.parking.service.helper.RequestHelper;

/**
 * Command handler ensures that the commands provided as input from user or file are directed to specific providers
 * and their corresponding implementations. It makes use of the RequestHelper class to construct relevant request
 * objects to be supplied to the APIs.
 */
public class CommandHandler {

    private final Inquiry inquiryProvider;
    private final Parking parkingProvider;

    public CommandHandler(Parking parkingProvider, Inquiry inquiryProvider) {
        this.parkingProvider = parkingProvider;
        this.inquiryProvider = inquiryProvider;
    }

    // improvement: follow a pattern for command execution and take care of argument validations
    public void processCommand(String lineInput) throws BaseParkingException {
        String[] commandDetails = lineInput.split(" ");
        Command command = Command.getCommand(commandDetails[0]);
        switch (command) {
            case CREATE_PARKING_LOT:
                final CreateParkingRequest createParkingRequest = RequestHelper
                        .constructCreateParkingRequest(commandDetails[1]);
                final CreateParkingResponse parkingLot = parkingProvider.createParkingLot(createParkingRequest);
                System.out.println(parkingLot);
                break;
            case PARK_VEHICLE:
                final ParkingRequest parkingRequest = RequestHelper
                        .constructParkingRequest(commandDetails[1], commandDetails[2]);
                ParkingResponse parkingResponse = parkingProvider.parkVehicle(parkingRequest);
                System.out.println(parkingResponse);
                break;
            case LEAVE_PARKING:
                final LeaveParkingRequest leaveParkingRequest = RequestHelper
                        .constructLeaveParkingRequest(commandDetails[1]);
                final LeaveParkingResponse leaveParkingResponse = parkingProvider.leaveParking(leaveParkingRequest);
                System.out.println(leaveParkingResponse);
                break;
            case SHOW_PARKING_STATUS:
                final ParkingLotStatusResponse parkingLotStatusResponse = inquiryProvider.parkingLotStatus();
                System.out.println(parkingLotStatusResponse);
                break;
            case GET_SLOT_NUMBERS_FOR_CARS_WITH_COLOR:
                final SlotDetailsResponse slotDetailsResponse = inquiryProvider.getSlotNumbersFromColor(commandDetails[1]);
                System.out.println(slotDetailsResponse);
                break;
            case GET_REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOR:
                final RegistrationDetailsResponse registrationDetails =
                        inquiryProvider.getRegistrationNumbersFromColor(commandDetails[1]);
                System.out.println(registrationDetails);
                break;
            case GET_SLOT_NUMBER_FROM_REGISTRATION_NUMBER:
                final int slotNumberFromRegistrationNumber =
                        inquiryProvider.getSlotNumberFromRegistrationNumber(commandDetails[1]);
                System.out.println(slotNumberFromRegistrationNumber);
                break;
            case DISPATCH_RULE:
                DispatcherType dispatcherType = DispatcherType.valueOf("even_distribution".toUpperCase());
                parkingProvider.modifyDispatcher(dispatcherType);
                break;
            case EXIT:
                System.out.println("Thank you for using ParkIt :)");
                System.exit(0);
                break;
            case UNKNOWN_COMMAND:
            default:
                System.out.println("Unknown command name supplied.");
                System.out.println("Correct usages - 'create_parking_lot' | 'park' | 'leave' | 'status' | 'registration_numbers_for_cars_with_colour' | 'slot_numbers_for_cars_with_colour' | 'slot_number_for_registration_number' | 'exit' ");
                break;
        }
    }
}