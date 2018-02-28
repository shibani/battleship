package battleship;

import java.io.IOException;

public class Start {
    public static void main(String[] args) throws IOException {

        CLI example = new CLI();

        example.welcome();

        example.selectGameType();

        int choice = example.getGameType();

        example.confirmGameType(choice);

        example.selectFirstPlayer();

        int firstPlayer = example.getPlayerSelection();

        example.confirmPlayerSelection(firstPlayer);

        /*Board board = new Board();

        Game game = new Game();

        Player player1 = new Player();//check type

        Player player2 = new Player();//check type

        //game.board = board;
        //player1

        board.printBoard();*/
    }
}
