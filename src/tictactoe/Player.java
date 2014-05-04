package tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Player {

    private java.io.PrintStream printStream;
    private BufferedReader reader;
    private Integer playerNumber;
    private Board board;
    private ArrayList<Character> symbols;

    public Player(PrintStream printStream, BufferedReader reader, Integer playerNumber, Board board) {
        this.printStream = printStream;
        this.reader = reader;
        this.playerNumber = playerNumber;
        this.board = board;
        this.symbols = new ArrayList<Character>();
        symbols.add(' ');
        symbols.add('X');
        symbols.add('O');
    }

    public void move() {
        String input = "0";
        printStream.println("Please enter a number to move (1 to 9):");

        try {
            input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        board.mark(input, symbols.get(playerNumber));
    }

}
