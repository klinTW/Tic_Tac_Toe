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
    public void shouldAttemptToDisplayBoard() {
        testGame.play();
        verify(testBoard, atLeastOnce()).display();
    }

    @Test
    public void shouldAttemptToMakePlayer1Move() {
        testGame.play();
        verify(testPlayer1).move();
    }

    @Test
    public void shouldRedrawBoardAfterPlayer1Moves() {
        testGame.play();
        InOrder inOrder = inOrder(testBoard, testPlayer1);
        inOrder.verify(testBoard, times(1)).display();
        inOrder.verify(testPlayer1, times(1)).move();
        inOrder.verify(testBoard, times(1)).display();
    }

    @Test
    public void shouldAttemptToMakePlayer2MoveAfterPlayer1() {
        InOrder inOrder = inOrder(testPlayer1, testPlayer2);
        testGame.play();
        inOrder.verify(testPlayer1).move();
        inOrder.verify(testPlayer2).move();
    }

}