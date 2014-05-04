package tictactoe;

import org.junit.Before;
import org.junit.Test;

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
        verify(testBoard).display();
    }

    @Test
    public void shouldAttemptToMakePlayer1Move() {
        testGame.play();
        verify(testPlayer1).move();
    }

    /*@Test
    public void shouldRedrawBoardAfterPlayer1Moves() {
        testGame.play();
        InOrder inOrder = inOrder(testBoard, testPlayer1);
        inOrder.verify(testPlayer1).move();
        inOrder.verify(testBoard).display();
    }*/



}