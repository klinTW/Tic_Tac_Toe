package tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;

import static org.mockito.Mockito.*;

public class BoardTest {

    private Board testBoard;
    private BoardDisplayer displayer;
    private PrintStream printStream;
    private Player player;
    private Integer[] board, correctBoard1, correctBoard2;

    @Before
    public void setUp() {
        displayer = mock(BoardDisplayer.class);
        printStream = mock(PrintStream.class);
        player = mock(Player.class);
        testBoard = new Board(displayer, printStream);

        board = new Integer[9];
        Arrays.fill(board, 0);
        correctBoard1 = new Integer[9];
        Arrays.fill(board, 0);
        correctBoard1[0] = 1;
        correctBoard2 = new Integer[9];
        Arrays.fill(board, 0);
        correctBoard2[0] = 1;
        correctBoard2[1] = 2;
    }

    @Test
    public void shouldDisplayBoardAtBeginningOfEachTurn() {
        when(player.askForMove()).thenReturn(1);
        when(player.playMove(1, board)).thenReturn(correctBoard1);
        testBoard.playTurn(player);
        verify(displayer).displayBoard(board);
    }

    @Test
    public void shouldAskPlayerForMoveDuringEachTurn() {
        when(player.askForMove()).thenReturn(1);
        when(player.playMove(1, board)).thenReturn(correctBoard1);
        testBoard.playTurn(player);
        verify(player).askForMove();
    }

    @Test
    public void shouldAskPlayerToPlayTheirMove() {
        when(player.askForMove()).thenReturn(1);
        when(player.playMove(1, board)).thenReturn(correctBoard1);
        testBoard.playTurn(player);
        verify(player).playMove(1, board);
    }

    @Test
    public void shouldAskForAnotherMoveFromSamePlayerIfPreviousMoveWasRejected() {
        when(player.askForMove()).thenReturn(-1).thenReturn(1);
        when(player.playMove(-1, board)).thenReturn(board);
        when(player.playMove(1, board)).thenReturn(correctBoard1);
        testBoard.playTurn(player);
        verify(printStream).println("That move is either already taken or invalid.");
        verify(player, times(2)).askForMove();
    }

}