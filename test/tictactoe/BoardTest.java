package tictactoe;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest extends TestCase {

    private Board testBoard;
    private PrintStream printStream;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        testBoard = new Board();
    }

    @Test
    public void shouldDisplayBoardWhenStarted() {
        testBoard.displayBoard();
        verify(printStream).println("   |   |   ");
        verify(printStream).println("-----------");
        verify(printStream).println("   |   |   ");
        verify(printStream).println("-----------");
        verify(printStream).println("   |   |   ");
    }

}