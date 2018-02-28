package battleship;

import org.junit.Test;

import java.io.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class CLITest {

    @Test
    public void welcome() throws IOException {
        CLI testCli = new CLI();

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        testCli.welcome();

        bo.flush();

        String inputLines = new String(bo.toByteArray());

        assertTrue(inputLines.toString().contains("Welcome to Battleship"));
    }

    @Test
    public void selectGameType() throws IOException {
        CLI testCli = new CLI();

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        testCli.selectGameType();

        bo.flush();

        String inputLines = new String(bo.toByteArray());

        assertTrue(inputLines.toString().contains("Select from the following by entering 1 - 3:"));
        assertTrue(inputLines.toString().contains("1. Human vs. Computer"));
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

        assertTrue(inputLines.toString().contains("You entered: 1 for a Human vs. Computer game."));
    }

    @Test
    public void selectFirstPlayer() throws IOException {
        CLI testCli = new CLI();

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        testCli.selectFirstPlayer();

        bo.flush();

        String inputLines = new String(bo.toByteArray());
        assertTrue(inputLines.toString().contains("Next please select who should go first, enter 1 for Human or 2 for Computer"));
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

        assertTrue(inputLines.toString().contains("You selected: 1. Human Player goes first."));
    }
}