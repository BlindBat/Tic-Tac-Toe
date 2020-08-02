package tictactoe.game;

import tictactoe.ui.Theme;
import tictactoe.exceptions.CellOccupiedException;
import tictactoe.exceptions.UserException;

public class Field {
    public static final int SIZE = 3;
    public static final int CELLS_NUMBER = SIZE * SIZE;
    public static char X = Theme.X;
    public static char O = Theme.O;
    public static char EMPTY = Theme.EMPTY;

    private char[][] field;

    private Stats xStats;
    private Stats oStats;

    private State state;
    private char currentPlayer = X;

    public Field() {
        this(new char[][]{
                {EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY}
        });
    }

    public Field(String string) {
        this(fieldToState(string));
    }

    public Field(char[][] field) {
        this.field = field;
        calcStats();
    }

    public void applyMove(Move move) throws UserException {
        if (field[move.getI()][move.getJ()] != EMPTY) {
            throw new CellOccupiedException(new Throwable());
        }
        field[move.getI()][move.getJ()] = getCurrentPlayer();
        calcStats();
        toggleCurrentPlayer();
    }

    private void resetStats() {
        xStats = new Stats(0, false);
        oStats = new Stats(0, false);
    }

    public void calcStats() {
        resetStats();
        calcCounters();
        xStats.checkCounters();
        oStats.checkCounters();
        state = calcState();
    }

    private void calcCounters() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int isX = field[i][j] == X ? 1 : 0;
                int isO = field[i][j] == O ? 1 : 0;

                // Occurrences
                xStats.addOccurrences(isX);
                oStats.addOccurrences(isO);

                // Primary diagonal
                if (i == j) {
                    xStats.getCounters().addToDiaPrimary(isX);
                    oStats.getCounters().addToDiaPrimary(isO);
                }

                // Secondary diagonal
                if (field.length - i - 1 == j) {
                    xStats.getCounters().addToDiaSecondary(isX);
                    oStats.getCounters().addToDiaSecondary(isO);
                }

                // Rows
                xStats.getCounters().addToRow(i, isX);
                oStats.getCounters().addToRow(i, isO);

                // Columns
                xStats.getCounters().addToColumn(j, isX);
                oStats.getCounters().addToColumn(j, isO);
            }
        }
    }

    public boolean isFinished() {
        return state != State.GAME_NOT_FINISHED;
    }

    private State calcState() {
        if (Math.abs(xStats.getOccurrences() - oStats.getOccurrences()) >= 2) {
            return State.IMPOSSIBLE;
        }
        if (xStats.hasRow() && oStats.hasRow()) {
            return State.IMPOSSIBLE;
        }
        if (xStats.hasRow() || oStats.hasRow()) {
            return xStats.hasRow() ? State.X_WINS : State.O_WINS;
        }
        if (xStats.getOccurrences() + oStats.getOccurrences() == CELLS_NUMBER) {
            return State.DRAW;
        }
        return State.GAME_NOT_FINISHED;
    }

    public State getState() {
        return state;
    }

    public String getStateString() {
        return State.STRINGS.get(getState());
    }

    public void setState(State state) {
        this.state = state;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void toggleCurrentPlayer() {
        currentPlayer = currentPlayer == X ? O : X;
    }

    public static char[][] fieldToState(String fieldStr) {
        char[] runes = fieldStr.toCharArray();
        int i = 0, j = 0;
        char[][] field = new char[3][3];
        for (char rune :
                runes) {
            field[i][j++] = rune;
            if (j == 3) {
                j = 0;
                i++;
            }
        }
        return field;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Theme.LINE);

        for (char[] row : field) {
            stringBuilder.append(Theme.DELIMITER).append(" ");
            for (char c : row) {
                stringBuilder.append(c).append(" ");
            }
            stringBuilder.append(Theme.DELIMITER).append("\n");
        }
        stringBuilder.append(Theme.LINE);
        return stringBuilder.toString();
    }
}
