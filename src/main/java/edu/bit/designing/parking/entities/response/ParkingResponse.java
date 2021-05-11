package edu.bit.designing.parking.entities.response;

import edu.bit.designing.parking.data.slot.Location;

public class ParkingResponse {
    Location location;

    public ParkingResponse(Location location) {
        this.location = location;
    }

    public static ParkingResponse voidResponse() {
        return new ParkingResponse(null);
    }

    @Override
    public String toString() {
        if (location == null) {
            return "Sorry, parking lot is full";
        } else {
            return "Allocated slot number: " + location;
        }
    }

    public Location getLocation() {
        return location;
    }
}