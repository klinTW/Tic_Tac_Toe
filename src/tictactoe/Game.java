package tictactoe;

public class Game {

    private Board gameBoard;
    private Player player1;
    private Player player2;

    public Game(Board board, Player player1, Player player2) {
        this.gameBoard = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() {
        gameBoard.display();
        player1.move();

        gameBoard.display();
        player2.move();

    }
}
