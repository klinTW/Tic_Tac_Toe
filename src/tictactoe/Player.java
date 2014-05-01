package tictactoe;

import java.io.PrintStream;

public class Player {

    private java.io.PrintStream printStream;

    public Player(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void askForMove() {
        printStream.println("Please enter a number to move (1 to 9):");
    }
}
