package edu.bit.designing.parking.entities.response;

public class LeaveParkingResponse {
    int slotNumber;

    public LeaveParkingResponse(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    @Override
    public String toString() {
        return "Slot number " + slotNumber + " is free";
    }
}