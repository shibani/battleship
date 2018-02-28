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

        Board board = new Board();

        Game game = new Game(board);

        example.printBoard(board);

        Human player1 = new Human();//check type

        Computer player2 = new Computer();//check type

        //game.board = board;
        //player1
    }
}
