package tictactoe.game;

import tictactoe.exceptions.CoordinatesNotInRange;
import tictactoe.exceptions.UserException;

public class Move {
    private int x;
    private int y;
    private int i;
    private int j;

    public Move(int x, int y) throws UserException {
        if (x > Field.SIZE || y > Field.SIZE) {
            throw new CoordinatesNotInRange(new Throwable());
        }
        this.x = x;
        this.y = y;
        i = Field.SIZE - y;
        j = x - 1;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
