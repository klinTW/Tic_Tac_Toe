package tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PlayerTest {

    private Player testPlayer;
    private PrintStream printStream;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        testPlayer = new Player(printStream);
    }

    @Test
    public void shouldPromptPlayerForAMove() {
        testPlayer.askForMove();
        verify(printStream).println("Please enter a number to move (1 to 9):");
    }

}