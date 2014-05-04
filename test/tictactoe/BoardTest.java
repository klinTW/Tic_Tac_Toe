package tictactoe;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;
import java.util.Arrays;

import static org.mockito.Mockito.*;

public class BoardTest {

    private Board testBoard;
    private PrintStream printStream;
    private Player player;
    private Integer[] board, correctBoard;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        player = mock(Player.class);
        testBoard = new Board(printStream);

        board = new Integer[9];
        Arrays.fill(board, 0);
        correctBoard = new Integer[9];
        Arrays.fill(board, 0);
        correctBoard[0] = 1;
    }

    @Test
    public void shouldDisplayBlankBoardWhenNoMarksMade() {
        testBoard.display();
        InOrder inOrder = inOrder(printStream);
        inOrder.verify(printStream).println(" | | ");
        inOrder.verify(printStream).println("-----");
        inOrder.verify(printStream).println(" | | ");
        inOrder.verify(printStream).println("-----");
        inOrder.verify(printStream).println(" | | ");
    }

    @Test
    public void shouldMarkSpaceOnBoardWhenGivenInput() {
        testBoard.mark("1");
        testBoard.display();
        InOrder inOrder = inOrder(printStream);
        inOrder.verify(printStream).println("X| | ");
        inOrder.verify(printStream).println("-----");
        inOrder.verify(printStream).println(" | | ");
        inOrder.verify(printStream).println("-----");
        inOrder.verify(printStream).println(" | | ");
    }

}