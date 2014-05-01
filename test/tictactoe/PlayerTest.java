package tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlayerTest {

    private Player testPlayer;
    private Player testPlayer2;
    private PrintStream printStream;
    private BufferedReader reader;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        testPlayer = new Player(printStream, reader, 1);
        testPlayer2 = new Player(printStream, reader, 2);
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

    @Test
    public void shouldModifyGivenBoardWithValidMove() {
        Integer[] board = new Integer[9];
        Arrays.fill(board, 0);
        Integer[] finalBoard = {1, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(testPlayer.playMove(1, board), finalBoard);
    }

    @Test
    public void shouldNotModifyGivenBoardWithInvalidInput() {
        Integer[] board = new Integer[9];
        Arrays.fill(board, 0);
        assertArrayEquals(testPlayer.playMove(-1, board), board);
    }

    @Test
    public void shouldModifyBoardWith2sWhenPlayer2IsPlaying() {
        Integer[] board = new Integer[9];
        Arrays.fill(board, 0);
        Integer[] finalBoard = {2, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(testPlayer2.playMove(1, board), finalBoard);
    }

    @Test
    public void shouldNotModifyBoardIfSpaceIsAlreadyTaken() {
        Integer[] board = {1, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(testPlayer.playMove(1, board), board);
        assertArrayEquals(testPlayer2.playMove(1, board), board);
    }

}