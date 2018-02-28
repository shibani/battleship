package battleship;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;


public class BoardTest {

    @Test
    public void getPositions() {
        Board testBoard = new Board();
        ArrayList<Integer> result = testBoard.getPositions();

        assertEquals(100, result.size());
    }

    @Test
    public void setPositions() {
    }

    @Test
    public void getTotalPositions() {
        Board testBoard = new Board();

        assertEquals(100, testBoard.getTotalPositions());
    }
}