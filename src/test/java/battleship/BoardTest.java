package battleship;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;


public class BoardTest {

    @Test
    public void setPositions() {
        Board testBoard = new Board();
        ArrayList<String> result = testBoard.getPositions();

        assertEquals(100, result.size());
    }

    @Test
    public void getPositions() {
        Board testBoard = new Board();
        ArrayList<String> result = testBoard.getPositions();

        assertEquals(" ", result.get(40));
    }

    @Test
    public void getTotalPositions() {
        Board testBoard = new Board();

        assertEquals(100, testBoard.getTotalPositions());
    }

    @Test
    public void isEmpty(){
        Board testBoard = new Board();

        boolean result = testBoard.isEmpty(36);
        assertEquals(true, result);
    }
}