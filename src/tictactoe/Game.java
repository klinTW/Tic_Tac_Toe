package tictactoe;

public class Game {

    private Board gameBoard;

    public Game(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void start() {
        gameBoard.displayBoard();
    }
}
