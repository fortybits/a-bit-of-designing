package edu.bit.designing.parking.entities.request;

public class LeaveParkingRequest {
    int slotNumber;
    int parkingLot;

    public LeaveParkingRequest(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public int getParkingLot() {
        return parkingLot;
    }

    public int getSlotNumber() {
        return slotNumber;
    }
}
