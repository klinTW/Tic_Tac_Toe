package tictactoe;

import java.io.PrintStream;

public class BoardDisplayer {
    Character[] symbols = {' ', 'X'};
    private PrintStream printStream;

    public BoardDisplayer(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void displayBoard(Integer[] board) {
        printStream.println(symbols[board[0]] + "|" + symbols[board[1]] + "|" + symbols[board[2]]);
        printStream.println("-----");
        printStream.println(symbols[board[3]] + "|" + symbols[board[4]] + "|" + symbols[board[5]]);
        printStream.println("-----");
        printStream.println(symbols[board[6]] + "|" + symbols[board[7]] + "|" + symbols[board[8]]);
    }
}
