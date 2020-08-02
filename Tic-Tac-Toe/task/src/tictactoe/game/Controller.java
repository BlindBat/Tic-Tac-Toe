package tictactoe.game;

import tictactoe.exceptions.NotANumbersException;
import tictactoe.exceptions.UserException;
import tictactoe.game.Field;
import tictactoe.game.Move;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Controller {
    private final Scanner scanner;
    private final PrintStream printer;

    public Controller(InputStream inputStream, PrintStream printer) {
        this.scanner = new Scanner(inputStream);
        this.printer = printer;
    }

    public void startGame() {
        Field field = new Field();
        System.out.print(field);
        while (!field.isFinished()) {
            try {
                Move move = readMove();
                field.applyMove(move);
                System.out.print(field);
            } catch (UserException e) {
                System.out.println(e.toString());
            }
        }
        System.out.println(field.getStateString());
    }

    public Field readField() {
        printer.print("Enter cells: ");
        return new Field(scanner.nextLine());
    }

    public Move readMove() throws UserException {
        printer.print("Enter the coordinates: ");
        try {
            var xy = scanner.nextLine().split(" ");
            return new Move(
                    Integer.parseInt(xy[0]),
                    Integer.parseInt(xy[1])
            );
        } catch (NumberFormatException e) {
            throw new NotANumbersException(e);
        }
    }
}
