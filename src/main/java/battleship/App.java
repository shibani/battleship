package battleship;

import java.io.IOException;

public class App {
    private static Game game;
    private static CLI cli;

    public static void start() throws IOException {

        CLI example = new CLI();

        example.welcome();

        example.selectGameType();

        int choice = example.getGameType();

        example.confirmGameType(choice);

        example.selectFirstPlayer();

        int firstPlayer = example.getPlayerSelection();

        example.confirmPlayerSelection(firstPlayer);

        Game game = new Game();

        game.createPlayers(choice, firstPlayer);

        gameLoop(game, example);

    }

    public static void gameLoop(Game game, CLI cli) throws IOException {
        App.game = game;
        App.cli = cli;

        App.cli.announcePlayerTurn(game);

        App.cli.printBoard(game.getCurrentPlayer().getBoard());

        String move = App.cli.getMove(); //if Computer, output "Getting computer's move"

        int moveToInt = App.cli.coordsToPosition(move);

        int moveToBoard = game.getCurrentPlayer().potentialMove(moveToInt); //if Computer, generate random here

        //check if spot is open
        if(game.getCurrentPlayer().getBoard().isEmpty(moveToBoard)){
            game.makeMove(moveToBoard);
        } else {
            System.out.println("That position is taken. Please try again.");
            App.cli.printBoard(game.getCurrentPlayer().getBoard());
        }

        App.cli.printBoard(game.getCurrentPlayer().getBoard());

        //switch turn until game over

        //System.out.println("\n\nPlayer 2's board");

        //System.out.println("Player 2 is " + game.getPlayer2().getClass().getName() + ". " +
        //game.getPlayer2().getClass().getName() + "'s turn:");

        //example.printBoard(game.getPlayer2().getBoard());

    }

}
