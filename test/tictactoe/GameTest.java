package tictactoe;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class GameTest {

    private Board testBoard;
    private Game testGame;
    private Player testPlayer1, testPlayer2;

    public GameTest() {
    }

    @Before
    public void setUp() {
        testBoard = mock(Board.class);
        testPlayer1 = mock(Player.class);
        testPlayer2 = mock(Player.class);
        testGame = new Game(testBoard, testPlayer1, testPlayer2);
    }

    @Test
    public void shouldAttemptToMakePlayer1Move() {
        testGame.start();
        verify(testBoard).playTurn(testPlayer1);
    }

    @Test
    public void shouldAttemptToMakePlayer2MoveAfterPlayer1() {
        testGame.start();
        InOrder inOrder = inOrder(testBoard);
        inOrder.verify(testBoard).playTurn(testPlayer1);
        inOrder.verify(testBoard).playTurn(testPlayer2);
    }

    @Test
    public void shouldKeepRunningUntilBoardIsFull() {
        when(testBoard.finished()).thenReturn(false).thenReturn(true);
        testGame.start();
        verify(testBoard, times(2)).playTurn(testPlayer1);
        verify(testBoard, times(2)).playTurn(testPlayer2);
    }

}