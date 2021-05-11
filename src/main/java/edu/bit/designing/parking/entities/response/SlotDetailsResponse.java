package edu.bit.designing.parking.entities.response;

import java.util.List;
import java.util.stream.Collectors;

public class SlotDetailsResponse {

    List<Integer> slotNumbers;

    public SlotDetailsResponse(List<Integer> slotNumbers) {
        this.slotNumbers = slotNumbers;
    }

    @Override
    public String toString() {
        return slotNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
