package edu.bit.designing.parking.data.vehicle;

public class Registration {
    String registrationNumber;

    public Registration(String registrationNumber) {
        this.registrationNumber = registrationNumber;
        validateRegistration();
    }

    // validate registration number
    public void validateRegistration() {
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public String toString() {
        return registrationNumber;
    }
}