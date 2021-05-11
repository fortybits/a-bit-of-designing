package edu.bit.designing.parking.data.slot;

public class Location {
    int number;

    public Location(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    /**
     * Method to return the score of a location's proximity for a given parking.
     * In this case, the value itself is returned for nearest slot.
     */
    public int proximity() {
        return number;
    }

    public int getNumber() {
        return number;
    }
}