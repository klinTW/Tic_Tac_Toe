package tictactoe;

import java.io.PrintStream;
import java.util.Arrays;

public class Board {

    private Integer[] board;

    private BoardDisplayer displayer;
    private java.io.PrintStream printStream;

    public Board(BoardDisplayer displayer, PrintStream printStream) {
        this.displayer = displayer;
        this.printStream = printStream;
        this.board = new Integer[9];
        Arrays.fill(board, 0);
    }

    public void playTurn(Player player) {
        displayer.displayBoard(board);
        Integer move = player.askForMove();
        Integer[] modifiedBoard = player.playMove(move, board);
        if (intArrayEquals(board, modifiedBoard)) {
            printStream.println("That move is either already taken or invalid.");
            playTurn(player);
        } else {
            board = modifiedBoard;
        }
    }

    public boolean intArrayEquals(Integer[] array1, Integer[] array2) {
        if (array1.length == array2.length) {
            for (int i = 0; i < array1.length; i++) {
                if (!array1[i].equals(array2[i])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
