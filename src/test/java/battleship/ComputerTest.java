package battleship;

import org.hamcrest.beans.HasProperty;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

public class ComputerTest {

    @Test
    public void potentialMove(){
        Board testBoard = new Board();
        Player testPlayer1 = new Computer();

        int result = testPlayer1.potentialMove(30);

        assertEquals(30, result);
    }

    @Test
    public void getBoard() {
        Board testBoard = new Board();
        Player testPlayer1 = new Computer();

        assertThat(testPlayer1.getBoard(), instanceOf(Board.class));
    }

    @Test
    public void getWinCombo() {
        Player testPlayer1 = new Computer();

        int[] array1 = new int[]{1, 2};
        int[] array2 = new int[]{17, 18, 19};
        int[] array3 = new int[]{83, 84, 85};
        int[] array4 = new int[]{35, 45, 55, 65};
        int[] array5 = new int[]{38, 48, 58, 68, 78};

        int[][] testCombo = new int[5][];
        testCombo[0] = array1;
        testCombo[1] = array2;
        testCombo[2] = array3;
        testCombo[3] = array4;
        testCombo[4] = array5;

        Assert.assertArrayEquals(testCombo, testPlayer1.getWinCombo());
    }

    @Test
    public void setType() {
        Player player = new Computer();
        player.setType("User");

        assertThat(player, HasProperty.hasProperty("type"));

    }

    @Test
    public void getType() {
        Player player = new Computer();
        player.setType("User");

        assertEquals( "User", player.getType());
    }

    @Test
    public void setName() {
        Player player = new Computer();
        player.setName("Player1");

        assertThat(player, HasProperty.hasProperty("name"));
    }

    @Test
    public void getName() {
        Player player = new Computer();
        player.setType("Player1");

        assertEquals( "Player1", player.getType());
    }
}