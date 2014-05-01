package tictactoe;

import java.io.PrintStream;
import java.util.Arrays;

public class Board {

    private PrintStream printStream;
    private Integer[] moves;

    private Character[] symbols = {' ', 'X'};

    public Board(PrintStream printStream) {
        this.printStream = printStream;
        this.moves = new Integer[9];
        Arrays.fill(moves, 0);
    }

    public void displayBoard() {
        printStream.println(symbols[moves[0]] + "|" + symbols[moves[1]] + "|" + symbols[moves[2]]);
        printStream.println("-----");
        printStream.println(symbols[moves[3]] + "|" + symbols[moves[4]] + "|" + symbols[moves[5]]);
        printStream.println("-----");
        printStream.println(symbols[moves[6]] + "|" + symbols[moves[7]] + "|" + symbols[moves[8]]);
    }

    public void playMove(Player testPlayer1, Integer move) {
        if (move > 0) {
            moves[move - 1] = 1;
        }
    }
}
