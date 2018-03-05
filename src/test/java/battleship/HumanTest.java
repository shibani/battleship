package battleship;

import org.hamcrest.beans.HasProperty;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

public class HumanTest {

    @Test
    public void getBoard() {
        Board testBoard = new Board();
        Player testPlayer1 = new Human();

        assertThat(testPlayer1.getBoard(), instanceOf(Board.class));
    }

    @Test
    public void setType() {
        Game game = new Game();
        Player player = new Human();
        player.setType("User");

        assertThat(player, HasProperty.hasProperty("type"));

    }

    @Test
    public void getType() {
        Game game = new Game();
        Player player = new Human();
        player.setType("User");

        assertEquals( "User", player.getType());
    }

    @Test
    public void setName() {
        Player player = new Human();
        player.setName("Player1");

        assertThat(player, HasProperty.hasProperty("name"));
    }

    @Test
    public void getName() {
        Player player = new Human();
        player.setType("Player1");

        assertEquals( "Player1", player.getType());
    }

    @Test
    public void potentialMove(){
        Board testBoard = new Board();
        Player testPlayer1 = new Human();

        int result = testPlayer1.potentialMove(30);

        assertEquals(30, result);
    }

    @Test
    public void setWinCombo() {
        Player testPlayer1 = new Human();
        String[][] testCombo = {
                {"1", "2"},
                {"17", "18", "19"},
                {"83", "84", "85"},
                {"35", "45", "55", "65"},
                {"38", "48", "58", "68", "78"}
        };

        Assert.assertArrayEquals(testCombo, testPlayer1.getWinCombo());
    }

    @Test
    public void getWinCombo() {
        Player testPlayer1 = new Human();

        String[][] testCombo = {
                {"1", "2"},
                {"17", "18", "19"},
                {"83", "X", "85"},
                {"35", "45", "55", "65"},
                {"38", "48", "58", "68", "78"}
        };

        testPlayer1.setWinCombo(2,1, "X");

        Assert.assertArrayEquals(testCombo, testPlayer1.getWinCombo());
    }


    @Test
    public void maxPossibleHits() {
        Player testPlayer1 = new Human();
        assertEquals(17, testPlayer1.maxPossibleHits());
    }
}