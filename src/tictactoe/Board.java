package tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;

public class Board {

    private ArrayList<Character> board;

    private java.io.PrintStream printStream;

    public Board(PrintStream printStream) {
        this.printStream = printStream;
        this.board = new ArrayList<Character>(9);
        for (int i = 0; i < 10; i++) {
            board.add(' ');
        }
    }

    public void display() {
        printStream.println(board.get(0) + "|" + board.get(1) + "|" + board.get(2));
        printStream.println("-----");
        printStream.println(board.get(3) + "|" + board.get(4) + "|" + board.get(5));
        printStream.println("-----");
        printStream.println(board.get(6) + "|" + board.get(7) + "|" + board.get(8));
    }

    public void mark(String input, char symbol) {
        Integer space = Integer.parseInt(input);
        board.set(space - 1, 'X');
    }

}
