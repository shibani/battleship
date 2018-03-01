package battleship;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

public class GameTest {

    @Test
    public void createPlayers() {
        Game game = new Game();
        game.createPlayers("Human vs. Computer","User");
        assertEquals(2, game.getPlayersArray().length);
    }

    @Test
    public void setPlayersArray() {
        Game game = new Game();
        game.createPlayers("Human vs. Computer","User");
        Player player = game.getPlayersArray()[0];
        assertThat(player, instanceOf(Player.class));
    }

    @Test
    public void getPlayersArray() {
        Game game = new Game();

        game.createPlayers("Human vs. Computer","User");
        assertEquals(2, game.getPlayersArray().length);
    }

    @Test
    public void getPlayer1() {
        Game game = new Game();
        game.createPlayers("Human vs. Computer","User");
        assertThat(game.player1, instanceOf(Human.class));
    }

    @Test
    public void getPlayer2() {
        Game game = new Game();
        game.createPlayers("Human vs. Computer","User");
        assertThat(game.player2, instanceOf(Computer.class));
    }
}