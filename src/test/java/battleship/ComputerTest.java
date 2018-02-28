package battleship;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ComputerTest {

    @Test
    public void name(){
        Player player1 = new Computer();

        assertEquals("TODO", player1.name());
    }

    @Test
    public void move(){
        Player player1 = new Computer();

        assertEquals("TODO", player1.move());
    }
}