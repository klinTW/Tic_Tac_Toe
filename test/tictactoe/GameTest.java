package tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameTest {

    private Board testBoard;
    private Game testGame;
    private Player testPlayer1;

    public GameTest() {
    }

    @Before
    public void setUp() {
        testBoard = mock(Board.class);
        testPlayer1 = mock(Player.class);
        testGame = new Game(testBoard, testPlayer1);
    }

    @Test
    public void shouldAttemptToMakePlayer1Move() {
        testGame.start();
        verify(testBoard).playTurn(testPlayer1);
    }

}