package battleship;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.beans.HasProperty.hasProperty;
import static org.junit.Assert.assertThat;

public class GameTest {

    @Test
    public void createPlayers() {
        Game game = new Game();
        game.createPlayers(1,1);
        assertEquals(2, game.getPlayersArray().length);
    }

    @Test
    public void setPlayersArray() {
        Game game = new Game();
        game.createPlayers(1,1);
        Player player = game.getPlayersArray()[0];
        assertThat(player, instanceOf(Player.class));
    }

    @Test
    public void getPlayersArray() {
        Game game = new Game();

        game.createPlayers(1,1);
        assertEquals(2, game.getPlayersArray().length);
    }

    @Test
    public void getPlayer1() {
        Game game = new Game();
        game.createPlayers(1,1);
        assertThat(game.player1, instanceOf(Human.class));
    }

    @Test
    public void getPlayer2() {
        Game game = new Game();
        game.createPlayers(1,1);
        assertThat(game.player2, instanceOf(Computer.class));
    }

    @Test
    public void playerTypeCheck1() {
        Game game = new Game();
        game.createPlayers(1,1);

        assertThat(game.player1, hasProperty("type"));
    }

    @Test
    public void playerTypeCheck2() {
        Game game = new Game();
        game.createPlayers(1,2);

        assertEquals("Opponent", game.player1.getType());
    }

    @Test
    public void setCurrentPlayer() {
        Game game = new Game();
        game.createPlayers(1,2);

        assertEquals("Opponent", game.getCurrentPlayer().getType());
    }

    @Test
    public void getCurrentPlayer() {
        Game game = new Game();
        game.createPlayers(1,2);
        game.setCurrentPlayer();

        assertEquals("User", game.getCurrentPlayer().getType());
    }

    @Test
    public void moveReturnsAHit1() {
        Game game = new Game();
        game.createPlayers(1,1);
        game.setCurrentPlayer();

        String result = game.makeMove(45);

        assertEquals("X", game.getCurrentPlayer().getBoard().getPositions().get(45));
    }

    @Test
    public void moveReturnsAHit2() {
        Game game = new Game();
        game.createPlayers(1,1);
        game.setCurrentPlayer();

        String result = game.makeMove(35);

        assertEquals("hit", result);
    }

    @Test
    public void moveReturnsAMiss1() {
        Game game = new Game();
        game.createPlayers(1,1);
        game.setCurrentPlayer();

        String result = game.makeMove(24);

        assertEquals("n", game.getCurrentPlayer().getBoard().getPositions().get(24));
    }

    @Test
    public void moveReturnsAMiss2() {
        Game game = new Game();
        game.createPlayers(1,1);
        game.setCurrentPlayer();

        String result = game.makeMove(24);

        assertEquals("miss", result);
    }

    @Test
    public void shipIsHit() {
        Game game = new Game();
        game.createPlayers(1,1);
        game.setCurrentPlayer();

        game.getCurrentPlayer().getBoard().getPositions().set(1, "X");
        game.getCurrentPlayer().getBoard().getPositions().set(2, "X");

        assertEquals("hit", game.shipIsHit(85));
    }

    @Test
    public void shipIsSunk() {
        Game game = new Game();
        game.createPlayers(1,1);
        game.setCurrentPlayer();
        game.getCurrentPlayer().getBoard().getPositions().set(83, "X");
        game.getCurrentPlayer().getBoard().getPositions().set(84, "X");

        assertEquals("sunk", game.shipIsHit(85));
    }

    @Test
    public void noShipsHit() {
        Game game = new Game();
        game.createPlayers(1,1);
        game.setCurrentPlayer();

        game.getCurrentPlayer().getBoard().getPositions().set(1, "X");
        game.getCurrentPlayer().getBoard().getPositions().set(2, "X");

        assertEquals("miss", game.shipIsHit(23));
    }

    @Test
    public void isWon() {
        Game game = new Game();
        game.createPlayers(1,1);
        game.setCurrentPlayer();

        game.getCurrentPlayer().getBoard().getPositions().set(1, "X");
        game.getCurrentPlayer().getBoard().getPositions().set(17, "X");
        game.getCurrentPlayer().getBoard().getPositions().set(18, "X");
        game.getCurrentPlayer().getBoard().getPositions().set(19, "X");
        game.getCurrentPlayer().getBoard().getPositions().set(83, "X");
        game.getCurrentPlayer().getBoard().getPositions().set(84, "X");
        game.getCurrentPlayer().getBoard().getPositions().set(85, "X");
        game.getCurrentPlayer().getBoard().getPositions().set(35, "X");
        game.getCurrentPlayer().getBoard().getPositions().set(45, "X");
        game.getCurrentPlayer().getBoard().getPositions().set(55, "X");
        game.getCurrentPlayer().getBoard().getPositions().set(65, "X");
        game.getCurrentPlayer().getBoard().getPositions().set(38, "X");
        game.getCurrentPlayer().getBoard().getPositions().set(48, "X");
        game.getCurrentPlayer().getBoard().getPositions().set(58, "X");
        game.getCurrentPlayer().getBoard().getPositions().set(68, "X");
        game.getCurrentPlayer().getBoard().getPositions().set(78, "X");

        game.shipIsHit(2);

        assertEquals(true, game.isWon());
    }
}