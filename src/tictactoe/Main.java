package tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {

    private static PrintStream printStream;
    private static BufferedReader reader;
    private static Board board;
    private static Game game;
    private static Player player1;

    public static void main (String[] args) {
        printStream = new PrintStream(System.out);
        reader = new BufferedReader(new InputStreamReader(System.in));
        board = new Board(printStream);
        player1 = new Player(printStream, reader);
        game = new Game(board, player1);

        game.start();
    }
}
