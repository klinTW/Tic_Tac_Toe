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
        InOrder inOrder = inOrder(printStream, printStream, printStream, printStream, printStream);
        inOrder.verify(printStream).println("   |   |   ");
        inOrder.verify(printStream).println("-----------");
        inOrder.verify(printStream).println("   |   |   ");
        inOrder.verify(printStream).println("-----------");
        inOrder.verify(printStream).println("   |   |   ");
    }

}