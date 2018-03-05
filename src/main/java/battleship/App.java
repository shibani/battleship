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

        while(!game.isWon()){
            gameLoop(game, example);
            game.setCurrentPlayer();
        }
    }

    public static void gameLoop(Game game, CLI cli) throws IOException {
        App.game = game;
        App.cli = cli;

        App.cli.announcePlayerTurn(game);
        App.cli.printBoard(game.getCurrentPlayer().getBoard());

        if (game.getCurrentPlayer().getClass().getName().contains("Human")) {
            String move = App.cli.getHumanMove();
            int moveToInt = App.cli.coordsToPosition(move);
            int moveToBoard = App.game.getCurrentPlayer().potentialMove(moveToInt);
            markBoardAndSendMessages(moveToBoard);
        } else {
            App.cli.getComputerMove();
            int moveToBoard = App.game.getCurrentPlayer().potentialMove(123);
            markBoardAndSendMessages(moveToBoard);
        }
    }


    public static void markBoardAndSendMessages(int move) throws IOException {
        if(game.getCurrentPlayer().getBoard().isEmpty(move)){
            String gameStatus = game.makeMove(move);
            if (gameStatus.equals("hit")){
                App.cli.hit(game.getCurrentPlayer());
                App.cli.printBoard(game.getCurrentPlayer().getBoard());
            } else if (gameStatus.equals("sunk")){
                App.cli.sunk(game.getCurrentPlayer());
                App.cli.printBoard(game.getCurrentPlayer().getBoard());
            } else if(gameStatus.equals("won")){
                App.cli.wonMessage(game.getCurrentPlayer());
            } else {
                App.cli.miss(game.getCurrentPlayer());
                App.cli.printBoard(game.getCurrentPlayer().getBoard());
            }
        } else {
            System.out.println("That position is taken. Please try again.");
            gameLoop(App.game, App.cli);
        }
    }
}
