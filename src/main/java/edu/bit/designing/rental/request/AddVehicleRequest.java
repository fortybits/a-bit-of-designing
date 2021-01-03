package edu.bit.designing.rental.request;

import edu.bit.designing.rental.entities.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddVehicleRequest {
    int quantity;
    VehicleType vehicleType;
}
