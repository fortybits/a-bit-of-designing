package edu.bit.designing.parking.command;

import edu.bit.designing.parking.entities.request.CreateParkingRequest;
import edu.bit.designing.parking.entities.response.CreateParkingResponse;

public class ParkingLotExecutor implements Executor<CreateParkingRequest, CreateParkingResponse> {

    @Override
    public CreateParkingRequest createRequest(String[] args) {
        return null;
    }

    @Override
    public CreateParkingResponse callService(CreateParkingRequest request) {
        return null;
    }

    @Override
    public void writeResponse(CreateParkingResponse response) {

    }
}