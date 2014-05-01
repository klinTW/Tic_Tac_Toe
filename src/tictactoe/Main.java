package tictactoe;

import java.io.PrintStream;

public class Main {

    private static PrintStream myPrintStream;
    private static Board myBoard;
    private static Game myGame;
    private static Player myPlayer1;

    public static void main (String[] args) {
        myPrintStream = new PrintStream(System.out);
        myBoard = new Board(myPrintStream);
        myPlayer1 = new Player(myPrintStream);
        myGame = new Game(myBoard, myPlayer1);

        myGame.start();
    }
}
