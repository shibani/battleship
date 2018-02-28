package battleship;

import org.junit.Test;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

public class GameTest {

    @Test
    public void getBoard(){
        Board testboard = new Board();
        Game testGame = new Game(testboard);

        assertThat(testGame.getBoard(), instanceOf(Board.class));
    }

}