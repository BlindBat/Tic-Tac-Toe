package tictactoe.game;

public class Counters {
    private int diaPrimary;
    private int diaSecondary;
    private int[] rows;
    private int[] columns;

    public Counters(int j) {
        rows = new int[j];
        columns = new int[j];
    }

    public void addToDiaPrimary(int count) {
        diaPrimary += count;
    }

    public int getDiaPrimary() {
        return diaPrimary;
    }

    public void addToDiaSecondary(int count) {
        diaSecondary += count;
    }

    public int getDiaSecondary() {
        return diaSecondary;
    }

    public void addToRow(int i, int count) {
        rows[i] += count;
    }

    public int[] getRows() {
        return rows;
    }

    public void addToColumn(int i, int count) {
        columns[i] += count;
    }

    public int[] getColumns() {
        return columns;
    }
}
