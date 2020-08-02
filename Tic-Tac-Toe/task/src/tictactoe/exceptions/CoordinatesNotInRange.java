package tictactoe.exceptions;

import tictactoe.game.Field;

public class CoordinatesNotInRange extends UserException {
    public CoordinatesNotInRange(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return "Coordinates should be from 1 to " + Field.SIZE;
    }
}
