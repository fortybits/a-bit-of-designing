package edu.bit.designing.rental.service;

import edu.bit.designing.rental.entities.Vehicle;
import edu.bit.designing.rental.request.BranchVehicleRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CityRentalService {

    abstract void addBranch(String branchName, List<BranchVehicleRequest> branchAddRequests);

    abstract void addVehicle(String branchName, Vehicle vehicle);

    static Map<Vehicle.VehicleType, Map<Integer, List<Vehicle>>> vehicleTypeSlotView = new HashMap<>();

    abstract String rentVehicle(Vehicle.VehicleType vehicleType, Long startTime, Long endTime);

    static Map<String, Map<Integer, List<Vehicle>>> branchSlotView = new HashMap<>();

    abstract String getAvailableVehicles(String branchName, Long startTime, Long endTime);
}