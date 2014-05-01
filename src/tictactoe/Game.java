package tictactoe;

public class Game {

    private Board gameBoard;
    private Player player1;

    public Game(Board gameBoard, Player player1) {
        this.gameBoard = gameBoard;
        this.player1 = player1;
    }

    public void start() {
        gameBoard.displayBoard();
        player1.askForMove();
    }
}
