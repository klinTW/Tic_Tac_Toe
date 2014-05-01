package tictactoe;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @Test
    public void shouldPassPlayer1AnswerToBoard() {
        when(testPlayer1.askForMove()).thenReturn(1);
        testGame.start();
        verify(testBoard).playMove(testPlayer1, 1);
    }

}