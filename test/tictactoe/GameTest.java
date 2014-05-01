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
    public void shouldAttemptToDisplayBoardWhenStart() {
        testGame.start();
        verify(testBoard).displayBoard();
    }

    @Test
    public void shouldAttemptToPromptPlayer1ForNumberAfterBoardDisplay() {
        testGame.start();
        verify(testPlayer1).askForMove();
    }

}