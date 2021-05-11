package edu.bit.designing.parking.data.slot;

import edu.bit.designing.parking.data.vehicle.Vehicle;

public abstract class Slot {
    private final int slotNumber;
    boolean occupied;
    private Location coordinates;
    private Vehicle vehicle;
    private SlotType slotType;

    public Slot(int slotNumber, SlotType slotType) {
        this.slotNumber = slotNumber;
        this.slotType = slotType;
        this.coordinates = new Location(slotNumber);
    }

    /**
     * Considering multiple modification to a slot might happen at the same time
     * e.g. two park command triggered at the same time might result in a race condition
     *
     * @param vehicle vehicle to be allotted to the slot or null of leaving
     */
    public void modifySlot(Vehicle vehicle) {
        synchronized (this) {
            this.vehicle = vehicle;
            this.occupied = vehicle != null;
        }
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public Location getCoordinates() {
        return coordinates;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Slot slot = (Slot) o;

        return slotNumber == slot.slotNumber;
    }

    @Override
    public int hashCode() {
        return slotNumber;
    }
}