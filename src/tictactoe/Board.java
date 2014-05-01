package tictactoe;

import java.io.PrintStream;

public class Board {

    private PrintStream printStream;

    public Board(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void displayBoard() {
        printStream.println("   |   |   ");
        printStream.println("-----------");
        printStream.println("   |   |   ");
        printStream.println("-----------");
        printStream.println("   |   |   ");
    }
}
