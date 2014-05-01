package tictactoe;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

public class BoardDisplayerTest {

    private BoardDisplayer testDisplayer;
    private PrintStream printStream;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        testDisplayer = new BoardDisplayer(printStream);
    }

    @Test
    public void shouldPrintBoard() {
        Integer[] board = {0, 1, 0, 0, 2, 0, 0, 0, 0};
        testDisplayer.displayBoard(board);
        InOrder inOrder = inOrder(printStream);
        inOrder.verify(printStream).println(" |X| ");
        inOrder.verify(printStream).println("-----");
        inOrder.verify(printStream).println(" |O| ");
        inOrder.verify(printStream).println("-----");
        inOrder.verify(printStream).println(" | | ");
    }

}