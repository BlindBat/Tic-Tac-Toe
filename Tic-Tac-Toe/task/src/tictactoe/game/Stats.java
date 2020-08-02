package tictactoe.game;

import static tictactoe.game.Field.SIZE;

public class Stats {
    private int occurrences;
    private boolean hasRow;
    private Counters counters;

    public Stats(int occurrences, boolean hasRow) {
        this.occurrences = occurrences;
        this.hasRow = hasRow;
        this.counters = new Counters(SIZE);
    }

    public void checkCounters() {
        if (counters.getDiaPrimary() == SIZE) {
            hasRow = true;
            return;
        }
        if (counters.getDiaSecondary() == SIZE) {
            hasRow = true;
            return;
        }
        for (int i = 0; i < SIZE; i++) {
            if (counters.getColumns()[i] == SIZE) {
                hasRow = true;
                return;
            }
            if (counters.getRows()[i] == SIZE) {
                hasRow = true;
                return;
            }
        }
    }

    public int getOccurrences() {
        return occurrences;
    }

    public void addOccurrences(int count) {
        occurrences += count;
    }

    public boolean hasRow() {
        return hasRow;
    }

    public void setHasRow(boolean hasRow) {
        this.hasRow = hasRow;
    }

    public Counters getCounters() {
        return counters;
    }

    public void setCounters(Counters counters) {
        this.counters = counters;
    }
}
