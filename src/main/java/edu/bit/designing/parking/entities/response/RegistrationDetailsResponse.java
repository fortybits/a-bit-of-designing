package edu.bit.designing.parking.entities.response;

import edu.bit.designing.parking.data.vehicle.Registration;

import java.util.List;
import java.util.stream.Collectors;

public class RegistrationDetailsResponse {

    List<Registration> registrationNumbers;

    public RegistrationDetailsResponse(List<Registration> registrations) {
        this.registrationNumbers = registrations;
    }

    @Override
    public String toString() {
        return registrationNumbers.stream()
                .map(Registration::toString)
                .collect(Collectors.joining(", "));
    }
}
