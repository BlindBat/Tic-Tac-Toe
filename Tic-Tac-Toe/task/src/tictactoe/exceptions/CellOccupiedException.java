package tictactoe.exceptions;

public class CellOccupiedException extends UserException {
    public CellOccupiedException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return "This cell is occupied! Choose another one!";
    }
}
