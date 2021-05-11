package edu.bit.designing.parking.exception;

public class NoMatchingSlotsFoundException extends BaseParkingException {

    public NoMatchingSlotsFoundException(String message) {
        super(message);
    }
}