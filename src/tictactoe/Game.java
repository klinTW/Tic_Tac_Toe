package tictactoe;

public class Game {

    private Board gameBoard;
    private Player player1;

    public Game(Board board, Player player1) {
        this.gameBoard = board;
        this.player1 = player1;
    }

    public void start() {
        gameBoard.displayBoard();
        Integer move = player1.askForMove();
        gameBoard.playMove(player1, move);
    }
}
