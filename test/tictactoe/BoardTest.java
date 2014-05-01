package tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BoardTest {

    private Board testBoard;
    private BoardDisplayer displayer;

    @Before
    public void setUp() {
        displayer = mock(BoardDisplayer.class);
        testBoard = new Board(displayer);
    }

    @Test
    public void shouldDisplayBoardAtBeginningOfEachTurn() {
        Player player = mock(Player.class);
        Integer[] board = new Integer[9];
        Arrays.fill(board, 0);
        testBoard.playTurn(player);
        verify(displayer).displayBoard(board);
    }

    @Test
    public void shouldAskPlayerForMoveDuringEachTurn() {
        Player player = mock(Player.class);
        testBoard.playTurn(player);
        verify(player).askForMove();
    }

    @Test
    public void shouldAskPlayerToPlayTheirMove() {
        Player player = mock(Player.class);
        Integer[] board = new Integer[9];
        Arrays.fill(board, 0);
        when(player.askForMove()).thenReturn(1);
        testBoard.playTurn(player);
        verify(player).playMove(1, board);
    }

}