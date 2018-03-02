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
    public void makeMove() {
        Game game = new Game();
        game.createPlayers(1,1);
        game.setCurrentPlayer();
        game.getCurrentPlayer().getBoard().getPositions().set(36, "X");

        assertEquals("X", game.getCurrentPlayer().getBoard().getPositions().get(36));
    }

    @Test
    public void shipIsHit() {
        Game game = new Game();
        game.createPlayers(1,1);
        game.setCurrentPlayer();
        game.getCurrentPlayer().getBoard().getPositions().set(2, "X");

    }

    @Test
    public void shipIsSunk() {
    }

    @Test
    public void isWon() {
    }
}