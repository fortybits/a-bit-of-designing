package edu.bit.designing.parking.exception;

public class BaseParkingException extends Exception {
    public BaseParkingException(String message) {
        super(message);
    }

    public BaseParkingException(String message, Throwable cause) {
        super(message, cause);
    }
}
