package edu.bit.designing.parking.data.slot;

/**
 * Slots can be further categorised to change the lookup strategy based on additional user inputs.
 * e.g. from a combination of driver details and vehicle details
 */
public enum SlotType {
    DIFFERENTLY_ABLE("for differently able drivers"),
    MINI("for mini vehicles like Bike"),
    PREMIUM("for premium vehicles like Car");
    String description;

    SlotType(String description) {
        this.description = description;
    }
}
