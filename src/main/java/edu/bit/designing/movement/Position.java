package edu.bit.designing.movement;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Position {
    int row;
    int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Position clone() {
        return new Position(row, column);
    }
}