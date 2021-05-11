package edu.bit.designing.parking.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

class CommandHandlerTest {

    CommandHandler commandHandler;
    @Mock
    edu.bit.designing.parking.service.Parking parking;
    @Mock
    edu.bit.designing.parking.service.Inquiry inquiry;

    @BeforeEach
    void setup() {
        parking = Mockito.mock(edu.bit.designing.parking.service.Parking.class);
        inquiry = Mockito.mock(edu.bit.designing.parking.service.Inquiry.class);
        commandHandler = new CommandHandler(parking, inquiry);
    }

    @Test
    void testCreateParkingLotCommand() throws edu.bit.designing.parking.exception.BaseParkingException {
        String inputLine = "create_parking_lot 6";
        commandHandler.processCommand(inputLine);
        Mockito.verify(parking).createParkingLot(Mockito.any());
        Mockito.verifyNoMoreInteractions(parking);
        Mockito.verifyNoInteractions(inquiry);
    }

    @Test
    void testParkingCommand() throws edu.bit.designing.parking.exception.BaseParkingException {
        String inputLine = "park KA-01-HH-1234 White";
        commandHandler.processCommand(inputLine);
        Mockito.verify(parking).parkVehicle(Mockito.any());
        Mockito.verifyNoMoreInteractions(parking);
        Mockito.verifyNoInteractions(inquiry);
    }

    @Test
    void testLeaveCommand() throws edu.bit.designing.parking.exception.BaseParkingException {
        String inputLine = "leave 4";
        commandHandler.processCommand(inputLine);
        Mockito.verify(parking).leaveParking(Mockito.any());
        Mockito.verifyNoMoreInteractions(parking);
        Mockito.verifyNoInteractions(inquiry);
    }

    @Test
    void testStatusCommand() throws edu.bit.designing.parking.exception.BaseParkingException {
        String inputLine = "status";
        commandHandler.processCommand(inputLine);
        Mockito.verify(inquiry).parkingLotStatus();
        Mockito.verifyNoMoreInteractions(inquiry);
        Mockito.verifyNoInteractions(parking);
    }

    @Test
    void testGetRegistrationNumbersForCarsWithColor() throws edu.bit.designing.parking.exception.BaseParkingException {
        String inputLine = "registration_numbers_for_cars_with_colour WHITE";
        commandHandler.processCommand(inputLine);
        Mockito.verify(inquiry).getRegistrationNumbersFromColor(Mockito.any());
        Mockito.verifyNoMoreInteractions(inquiry);
        Mockito.verifyNoInteractions(parking);
    }

    @Test
    void testGetSlotNumbersWithColor() throws edu.bit.designing.parking.exception.BaseParkingException {
        String inputLine = "slot_numbers_for_cars_with_colour RED";
        commandHandler.processCommand(inputLine);
        Mockito.verify(inquiry).getSlotNumbersFromColor(Mockito.any());
        Mockito.verifyNoMoreInteractions(inquiry);
        Mockito.verifyNoInteractions(parking);
    }

    @Test
    void testGetSlotNumberFromRegistrationNumber() throws edu.bit.designing.parking.exception.BaseParkingException {
        String inputLine = "slot_number_for_registration_number KA-01-P-333";
        commandHandler.processCommand(inputLine);
        Mockito.verify(inquiry).getSlotNumberFromRegistrationNumber(Mockito.any());
        Mockito.verifyNoMoreInteractions(inquiry);
        Mockito.verifyNoInteractions(parking);
    }

    @Test
    void testInvalidCommands() throws edu.bit.designing.parking.exception.BaseParkingException {
        commandHandler.processCommand("create_parking_lots 6");
        commandHandler.processCommand("parks KA-01-P-333 WHITE");
        commandHandler.processCommand("leaves 6");
        commandHandler.processCommand("stats");
        commandHandler.processCommand("registration_for_cars_with_colour RED");
        commandHandler.processCommand("slot_numbers_with_colour RED");
        commandHandler.processCommand("slot_number_from_registration KA-01-P-333");
        Mockito.verifyNoInteractions(parking, inquiry);
    }
}