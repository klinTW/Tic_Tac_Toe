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
    private static BoardDisplayer displayer;

    public static void main (String[] args) {
        printStream = new PrintStream(System.out);
        reader = new BufferedReader(new InputStreamReader(System.in));
        displayer = new BoardDisplayer(printStream);
        board = new Board(displayer);
        player1 = new Player(printStream, reader);
        game = new Game(board, player1);

        game.start();
    }
}
