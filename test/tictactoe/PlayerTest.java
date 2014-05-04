package tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlayerTest {

    private Player testPlayer;
    private Player testPlayer2;
    private PrintStream printStream;
    private BufferedReader reader;
    private Board board;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        board = mock(Board.class);
        testPlayer = new Player(printStream, reader, 1, board);
        testPlayer2 = new Player(printStream, reader, 2, board);
    }

    @Test
    public void shouldPromptPlayerForInputWhenMoving() {
        testPlayer.move();
        verify(printStream).println("Please enter a number to move (1 to 9):");
    }

    @Test
    public void shouldAcceptInputWhenMoving() throws IOException {
        testPlayer.move();
        verify(reader).readLine();
    }

    @Test
    public void shouldMakeMoveOnBoardAfterGettingInput() throws IOException {
        when(reader.readLine()).thenReturn("1");
        testPlayer.move();
        verify(board).mark("1", 'X');
    }

    @Test
    public void shouldMarkAnOOnBoardIfPlayer2() throws IOException {
        when(reader.readLine()).thenReturn("2");
        testPlayer2.move();
        verify(board).mark("2", 'O');
    }

}