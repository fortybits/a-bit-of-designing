package edu.bit.designing.parking.entities.response;

public class CreateParkingResponse {
    int capacity;

    public CreateParkingResponse(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Created a parking lot with " + capacity + " slots";
    }
}
