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
        String coords = "j9";

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
    public void getHumanMove1() throws IOException {
        CLI testCli = new CLI();

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        Game game = new Game();
        game.createPlayers(1, 1);

        byte[] data = "D,8".getBytes();
        InputStream input = new ByteArrayInputStream(data);
        System.setIn(input);

        String testResult = testCli.getHumanMove();

        bo.flush();

        String inputLines = new String(bo.toByteArray());
        assertTrue(inputLines.contains("Enter your move with one letter for the row and one digit for the column, e.g 'd9':"));

    }

    @Test
    public void getHumanMove2() throws IOException {
        CLI testCli = new CLI();
        Game game = new Game();
        game.createPlayers(1, 1);

        byte[] data = "D,8".getBytes();
        InputStream input = new ByteArrayInputStream(data);
        System.setIn(input);

        String testResult = testCli.getHumanMove();

        assertEquals("D,8", testResult);
    }

    @Test
    public void getComputerMove() throws IOException {
        CLI testCli = new CLI();
        Game game = new Game();
        game.createPlayers(1, 1);

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        testCli.getComputerMove();

        bo.flush();

        String inputLines = new String(bo.toByteArray());
        assertTrue(inputLines.contains("Computer is generating a move"));
    }

    @Test
    public void wonMessage() throws IOException {
        CLI testCli = new CLI();
        Game game = new Game();
        game.createPlayers(1, 1);

        game.makeMove(1);
        game.makeMove(2);

        game.makeMove(17);
        game.makeMove(18);
        game.makeMove(19);

        game.makeMove(83);
        game.makeMove(84);
        game.makeMove(85);

        game.makeMove(35);
        game.makeMove(45);
        game.makeMove(55);
        game.makeMove(65);

        game.makeMove(38);
        game.makeMove(48);
        game.makeMove(58);
        game.makeMove(68);
        game.makeMove(78);

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        testCli.wonMessage(game.getCurrentPlayer());
        testCli.sunk(game.getCurrentPlayer());
        testCli.hit(game.getCurrentPlayer());
        testCli.miss(game.getCurrentPlayer());

        bo.flush();

        String inputLines = new String(bo.toByteArray());
        assertTrue(inputLines.contains("Player 1 won!\n Would you like to play again?"));
    }

    @Test
    public void sunk1() {
        CLI testCli = new CLI();
        Game game = new Game();
        game.createPlayers(1, 1);

        game.makeMove(17);
        game.makeMove(18);
        String result = game.makeMove(19);

        assertEquals("sunk", result);
    }

    @Test
    public void sunk2() throws IOException {
        CLI testCli = new CLI();
        Game game = new Game();
        game.createPlayers(1, 1);
        game.makeMove(17);
        game.makeMove(18);
        game.makeMove(19);

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        testCli.wonMessage(game.getCurrentPlayer());
        testCli.sunk(game.getCurrentPlayer());
        testCli.hit(game.getCurrentPlayer());
        testCli.miss(game.getCurrentPlayer());

        bo.flush();

        String inputLines = new String(bo.toByteArray());
        assertTrue(inputLines.contains("Player 1 sank a battleship!"));
    }

    @Test
    public void hit1() throws IOException {
        CLI testCli = new CLI();
        Game game = new Game();
        game.createPlayers(1, 1);

        String result = game.makeMove(35);

        assertEquals("hit", result);
    }

    @Test
    public void hit2() throws IOException {
        CLI testCli = new CLI();
        Game game = new Game();
        game.createPlayers(1, 1);
        game.makeMove(35);

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        testCli.wonMessage(game.getCurrentPlayer());
        testCli.sunk(game.getCurrentPlayer());
        testCli.hit(game.getCurrentPlayer());
        testCli.miss(game.getCurrentPlayer());

        bo.flush();

        String inputLines = new String(bo.toByteArray());
        assertTrue(inputLines.contains("Player 1 got a hit!"));
    }

    @Test
    public void miss1() throws IOException{
        CLI testCli = new CLI();
        Game game = new Game();
        game.createPlayers(1, 1);

        String result = game.makeMove(23);

        assertEquals("miss", result);
    }

    @Test
    public void miss2() throws IOException{
        CLI testCli = new CLI();
        Game game = new Game();
        game.createPlayers(1, 1);

        game.makeMove(23);

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));

        testCli.wonMessage(game.getCurrentPlayer());
        testCli.sunk(game.getCurrentPlayer());
        testCli.hit(game.getCurrentPlayer());
        testCli.miss(game.getCurrentPlayer());

        bo.flush();

        String inputLines = new String(bo.toByteArray());

        assertTrue(inputLines.contains("No ships were hit, Player 1 missed!"));
    }
}