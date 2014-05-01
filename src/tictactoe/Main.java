package tictactoe;

import java.io.PrintStream;

public class Main {

    private static PrintStream myPrintStream;
    private static Board myBoard;
    private static Game myGame;

    public static void main (String[] args) {
        myPrintStream = new PrintStream(System.out);
        myBoard = new Board(myPrintStream);
        myGame = new Game(myBoard);

        myGame.start();
    }
}
