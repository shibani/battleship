package battleship;

import org.junit.Test;

import java.io.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class CLITest {

    @Test
    public void welcome() throws IOException {
        CLI testCli = new CLI();

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        testCli.welcome();

        bo.flush();

        String inputLines = new String(bo.toByteArray());

        assertTrue(inputLines.contains("Welcome to Battleship"));
    }

    @Test
    public void selectGameType() throws IOException {
        CLI testCli = new CLI();

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        testCli.selectGameType();

        bo.flush();

        String inputLines = new String(bo.toByteArray());

        assertTrue(inputLines.contains("Select from the following by entering 1 - 3:"));
        assertTrue(inputLines.contains("1. Human vs. Computer"));
    }

    @Test
    public void getGameType() throws IOException {
        CLI testCli = new CLI();

        byte[] data = "1".getBytes();
        InputStream input = new ByteArrayInputStream(data);
        System.setIn(input);

        int testResult = testCli.getGameType();

        assertEquals(1, testResult);
    }

    @Test
    public void confirmGameType() throws IOException {
        CLI testCli = new CLI();

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        testCli.confirmGameType(1);

        bo.flush();

        String inputLines = new String(bo.toByteArray());

        assertTrue(inputLines.contains("You entered: 1 for a Human vs. Computer game."));
    }

    @Test
    public void selectFirstPlayer() throws IOException {
        CLI testCli = new CLI();

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        testCli.selectFirstPlayer();

        bo.flush();

        String inputLines = new String(bo.toByteArray());
        assertTrue(inputLines.toString().contains("Next please select who should go first, enter 1 for User or 2 for Opponent"));
    }

    @Test
    public void getPlayerSelection() throws IOException {
        CLI testCli = new CLI();

        byte[] data = "1".getBytes();
        InputStream input = new ByteArrayInputStream(data);
        System.setIn(input);

        int testResult = testCli.getPlayerSelection();

        assertEquals(1, testResult);
    }

    @Test
    public void confirmPlayerSelection() throws IOException {
        CLI testCli = new CLI();

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));


        testCli.confirmPlayerSelection(1);

        bo.flush();

        String inputLines = new String(bo.toByteArray());

        assertTrue(inputLines.contains("You selected: 1. User goes first."));
    }

    @Test
    public void printBoard() throws IOException {
        CLI testCli = new CLI();

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        Board board = new Board();

        testCli.printBoard(board);

        bo.flush();

        String inputLines = new String(bo.toByteArray());

        assertTrue(inputLines.contains(" +=====+=====+=====+=====+=====+=====+=====+=====+=====+=====+ "));
    }

    @Test
    public void coordsToPosition() {
        CLI testCli = new CLI();
        String coords = "J,9";

        assertEquals(99, testCli.coordsToPosition(coords));
    }

    @Test
    public void announcePlayerTurn() throws IOException {
        CLI testCli = new CLI();

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        Game game = new Game();
        game.createPlayers(1, 1);

        testCli.announcePlayerTurn(game);

        bo.flush();

        String inputLines = new String(bo.toByteArray());
        assertTrue(inputLines.contains("Player 1's board"));
    }

    @Test
    public void getMove1() throws IOException {
        CLI testCli = new CLI();

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        Game game = new Game();
        game.createPlayers(1, 1);

        byte[] data = "D,8".getBytes();
        InputStream input = new ByteArrayInputStream(data);
        System.setIn(input);

        String testResult = testCli.getMove();

        bo.flush();

        String inputLines = new String(bo.toByteArray());
        assertTrue(inputLines.contains("Enter your move with one letter for the row and one digit for the column separated by a comma:"));

    }

    @Test
    public void getMove2() throws IOException {
        CLI testCli = new CLI();
        Game game = new Game();
        game.createPlayers(1, 1);

        byte[] data = "D,8".getBytes();
        InputStream input = new ByteArrayInputStream(data);
        System.setIn(input);

        String testResult = testCli.getMove();

        assertEquals("D,8", testResult);
    }
}