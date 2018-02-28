package battleship;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class HumanTest {

    @Test
    public void name(){
        Player player1 = new Human();

        assertEquals("TODO", player1.name());
    }

    @Test
    public void move(){
        Player player1 = new Human();

        assertEquals("TODO", player1.move());
    }
}