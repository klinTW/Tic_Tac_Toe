package tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Player {

    private java.io.PrintStream printStream;
    private BufferedReader reader;
    private Integer playerNumber;

    public Player(PrintStream printStream, BufferedReader reader, Integer playerNumber) {
        this.printStream = printStream;
        this.reader = reader;
        this.playerNumber = playerNumber;
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

    public Integer[] playMove(Integer move, Integer[] board) {
        Integer[] newBoard = new Integer[9];
        for (int i = 0; i < 9; i++) {
            if (i == move-1 && board[i] != 0) {
                return board;
            }
            newBoard[i] = board[i];
        }

        if (move > 0 && move < 9) {
            newBoard[move - 1] = playerNumber;
        }


        return newBoard;
    }
}
