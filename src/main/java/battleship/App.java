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

        //while !game.isWon
        gameLoop(game, example);
        //switch currentplayer;

    }

    public static void gameLoop(Game game, CLI cli) throws IOException {
        App.game = game;
        App.cli = cli;

        App.cli.announcePlayerTurn(game);

        App.cli.printBoard(game.getCurrentPlayer().getBoard());

        String move = App.cli.getMove();

        int moveToInt = App.cli.coordsToPosition(move);

        int moveToBoard = game.getCurrentPlayer().potentialMove(moveToInt); //if Computer, generate random here

        //check if spot is open
        if(game.getCurrentPlayer().getBoard().isEmpty(moveToBoard)){
            String gameStatus = game.makeMove(moveToBoard);
            if( gameStatus.equals("won")){
                App.cli.wonMessage();
                App.cli.playAgain();
            } else if (gameStatus.equals("sunk")){
                App.cli.sunk();
                App.cli.printBoard(game.getCurrentPlayer().getBoard());
            } else if (gameStatus.equals("hit")){
                App.cli.hit();
                App.cli.printBoard(game.getCurrentPlayer().getBoard());
            } else {
                App.cli.miss();
                App.cli.printBoard(game.getCurrentPlayer().getBoard());
            }
        } else {
            System.out.println("That position is taken. Please try again.");
            App.cli.printBoard(game.getCurrentPlayer().getBoard());
        }
    }
}
