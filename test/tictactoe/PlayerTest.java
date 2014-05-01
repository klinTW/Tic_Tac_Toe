package tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlayerTest {

    private Player testPlayer;
    private PrintStream printStream;
    private BufferedReader reader;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        testPlayer = new Player(printStream, reader);
    }

    @Test
    public void shouldPromptPlayerForAMove() {
        testPlayer.askForMove();
        verify(printStream).println("Please enter a number to move (1 to 9):");
    }

    @Test
    public void shouldAllowPlayerToEnterAMoveAfterPrompt() throws IOException {
        testPlayer.askForMove();
        verify(reader).readLine();
    }

    @Test
    public void shouldPassMoveBackToGame() throws IOException {
        when(reader.readLine()).thenReturn("1");
        assertThat(testPlayer.askForMove(), is(1));
    }

}