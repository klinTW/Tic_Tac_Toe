package tictactoe;

import java.util.Arrays;

public class Board {

    private Integer[] board;

    private BoardDisplayer displayer;

    public Board(BoardDisplayer displayer) {
        this.displayer = displayer;
        this.board = new Integer[9];
        Arrays.fill(board, 0);
    }

    public void playTurn(Player player) {
        displayer.displayBoard(board);
        Integer move = player.askForMove();
        board = player.playMove(move, board);
    }
}
