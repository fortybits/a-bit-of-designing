package edu.bit.designing.parking.dispatch;

public enum DispatcherType {
    EVEN_DISTRIBUTION("even_distribution"),
    FILL_FIRST("fill_first");

    String value;

    DispatcherType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}