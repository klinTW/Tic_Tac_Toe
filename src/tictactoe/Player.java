package tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Player {

    private java.io.PrintStream printStream;
    private BufferedReader reader;
    private Integer playerNumber;
    private Board board;

    public Player(PrintStream printStream, BufferedReader reader, Integer playerNumber, Board board) {
        this.printStream = printStream;
        this.reader = reader;
        this.playerNumber = playerNumber;
        this.board = board;
    }

    public void move() {
        String input = "0";
        printStream.println("Please enter a number to move (1 to 9):");

        try {
            input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        board.mark(input);
    }

}
