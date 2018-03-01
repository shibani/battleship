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

        Game game = new Game();

        game.createPlayers(example.gameTypeChoices.get(choice), example.firstPlayer.get(firstPlayer));

        example.announcePlayer1Turn(game);

        example.printBoard(game.getPlayer1().getBoard());

        String move = example.getMove();

        int moveToInt = example.coordsToPosition(move);

        game.getPlayer1().potentialMove(moveToInt);

        //check if spot is open
        //if game.getPlayer1().board.isEmpty(moveToInt)

        //make move

        //System.out.println("\n\nPlayer 2's board");

        //System.out.println("Player 2 is " + game.getPlayer2().getClass().getName() + ". " +
                //game.getPlayer2().getClass().getName() + "'s turn:");

        //example.printBoard(game.getPlayer2().getBoard());
    }
}
