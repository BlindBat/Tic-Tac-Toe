package tictactoe.exceptions;

public class NotANumbersException extends UserException {
    public NotANumbersException(Throwable e) {
        super(e);
    }

    @Override
    public String toString() {
        return "You should enter numbers!";
    }
}
