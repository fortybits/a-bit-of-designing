package edu.bit.designing.rental.service;

import edu.bit.designing.rental.entities.Vehicle;
import edu.bit.designing.rental.request.BranchVehicleRequest;

import java.util.List;

public class RentalServiceProvider extends CityRentalService{


    @Override
    void addBranch(String branchName, List<BranchVehicleRequest> branchAddRequests) {

    }

    @Override
    void addVehicle(String branchName, Vehicle vehicle) {

    }

    @Override
    String rentVehicle(Vehicle.VehicleType vehicleType, Long startTime, Long endTime) {
        return null;
    }

    @Override
    String getAvailableVehicles(String branchName, Long startTime, Long endTime) {
        return null;
    }
}
