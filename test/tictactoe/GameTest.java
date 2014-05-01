package tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameTest {

    private Board testBoard;
    private Game testGame;

    @Before
    public void setUp() {
        testBoard = mock(Board.class);
        testGame = new Game(testBoard);
    }

    @Test
    public void shouldAttemptToDisplayBoardWhenStart() {
        testGame.start();
        verify(testBoard).displayBoard();
    }

}