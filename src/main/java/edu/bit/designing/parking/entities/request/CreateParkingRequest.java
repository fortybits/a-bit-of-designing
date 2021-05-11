package edu.bit.designing.parking.entities.request;

public class CreateParkingRequest {
    int lotId;
    int capacity;

    public CreateParkingRequest(int capacity) {
        this.capacity = capacity;
    }

    public int getLotId() {
        return lotId;
    }

    public int getCapacity() {
        return capacity;
    }
}