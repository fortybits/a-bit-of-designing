package edu.bit.designing.parking.data.vehicle;

public class Description {
    String color;

    public Description(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color;
    }
}
