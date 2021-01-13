package edu.bit.designing.rental.branch;

import edu.bit.designing.rental.entities.Vehicle;
import lombok.Getter;

import java.util.List;

@Getter
public class Branch {
    String branchId; // name
    List<Vehicle> vehicles;
}