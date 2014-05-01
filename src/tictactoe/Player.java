package tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Player {

    private java.io.PrintStream printStream;
    private BufferedReader reader;

    public Player(PrintStream printStream, BufferedReader reader) {
        this.printStream = printStream;
        this.reader = reader;
    }

    public Integer askForMove() {
        String returnValue;
        printStream.println("Please enter a number to move (1 to 9):");

        try {
            returnValue = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }

        if (returnValue != null) {
            return Integer.parseInt(returnValue);
        } else {
            return 0;
        }
    }
}
