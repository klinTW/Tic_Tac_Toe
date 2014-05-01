package tictactoe;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

public class BoardTest {

    private Board testBoard;
    private PrintStream printStream;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        testBoard = new Board(printStream);
    }

    @Test
    public void shouldPrintEmptyGridWhenFirstDisplaying() {
        testBoard.displayBoard();
        InOrder inOrder = inOrder(printStream);
        inOrder.verify(printStream).println(" | | ");
        inOrder.verify(printStream).println("-----");
        inOrder.verify(printStream).println(" | | ");
        inOrder.verify(printStream).println("-----");
        inOrder.verify(printStream).println(" | | ");
    }

    @Test
    public void shouldMarkDownPlayerMoveWhenPlayed() {
        Player testPlayer = mock(Player.class);
        InOrder inOrder = inOrder(printStream);
        testBoard.playMove(testPlayer, 1);
        testBoard.displayBoard();
        inOrder.verify(printStream).println("X| | ");
        inOrder.verify(printStream).println("-----");
        inOrder.verify(printStream).println(" | | ");
        inOrder.verify(printStream).println("-----");
        inOrder.verify(printStream).println(" | | ");
    }

    @Test
    public void shouldNotChangeBoardIfInvalidMovePlayed() {
        Player testPlayer = mock(Player.class);
        InOrder inOrder = inOrder(printStream);
        testBoard.playMove(testPlayer, -1);
        testBoard.displayBoard();
        inOrder.verify(printStream).println(" | | ");
        inOrder.verify(printStream).println("-----");
        inOrder.verify(printStream).println(" | | ");
        inOrder.verify(printStream).println("-----");
        inOrder.verify(printStream).println(" | | ");
    }

}