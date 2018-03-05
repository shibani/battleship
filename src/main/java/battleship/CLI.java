package battleship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CLI {

    public static final HashMap<Integer, String> gameTypeChoices = new HashMap<Integer, String>();
    public static final HashMap<Integer, String> firstPlayer = new HashMap<Integer, String>();
    private static final String[] alpha = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

    static {
        gameTypeChoices.put(1, "Human vs. Computer");
        gameTypeChoices.put(2, "Computer vs. Computer");
        gameTypeChoices.put(3, "Human vs. Human");
    }

    static {
        firstPlayer.put(1, "User");
        firstPlayer.put(2, "Opponent");
    }

    public void welcome() {
        System.out.println("==============================");
        System.out.println("    " + "Welcome to Battleship");
        System.out.println("==============================\n");
    }

    public void selectGameType() {
        System.out.println("Select from the following by entering 1 - 3:");
        for (Map.Entry<Integer, String> entry : gameTypeChoices.entrySet()) {
            int key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ". " + value);
        }
    }

    public int getGameType() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        return Integer.parseInt(input.trim());
    }

    public void confirmGameType(int choice){
        String choiceString = gameTypeChoices.get(choice);
        System.out.println("You entered: " + choice + " for a " + choiceString + " game.");
    }

    public void selectFirstPlayer() {
        System.out.println("Next please select who should go first, enter 1 for User or 2 for Opponent");
    }

    public int getPlayerSelection() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        return Integer.parseInt(input.trim());
    }

    public void confirmPlayerSelection(int selection){

        System.out.println("You selected: " + selection + ". " + firstPlayer.get(selection) + " goes first.\n");
    }

    public void printBoard(Board board) {

        ArrayList<String> positions = board.getPositions();

        int i = 0;

        System.out.println("      0     1     2     3     4     5     6     7     8     9    ");

        String border = "   +=====+=====+=====+=====+=====+=====+=====+=====+=====+=====+ ";

        System.out.println(border);
        System.out.print(" A | ");

        while(i < board.getTotalPositions()) {
             System.out.print((" " + positions.get(i) + " " + " | "));
             if(i % 10 == 9){
                System.out.print("\n");
                System.out.println(border);
                if(i != board.getTotalPositions() - 1){
                    System.out.print(" " + (alpha[(i/10) + 1]) + " | ");
                }
             }
             i++;
        }
    }

    public int coordsToPosition(String incoming){
        String coords = incoming.trim();
        String alpha = (Character.toString(coords.charAt(0)).toUpperCase());
        int num = Character.getNumericValue(coords.charAt(coords.length() - 1));

        int index = Arrays.asList(CLI.alpha).indexOf(alpha);
        return (index * 10) + num;
    }

    public void announcePlayerTurn(Game game){
        System.out.println(game.getCurrentPlayer().getName() +
                " is " + game.getCurrentPlayer().getType() + ". " + game.getCurrentPlayer().getName() + "'s turn.");
        System.out.println(game.getCurrentPlayer().getName() + "'s board:");

    }

    public String getHumanMove() throws IOException {
        System.out.println("Enter your move with one letter for the row and one digit for the column, e.g 'd9':");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    public void getComputerMove() throws IOException {
        System.out.println("Computer is generating a move.");
    }

    public void wonMessage(Player player){
        System.out.println(player.getName() + " won!\n Would you like to play again? Enter Y/N:");
    }

    public void sunk(Player player){
        System.out.println(player.getName() + " sank a battleship!");
    }

    public void hit(Player player){
        System.out.println(player.getName() + " got a hit!");
    }

    public void miss(Player player){
        System.out.println("No ships were hit, " + player.getName() +  " missed!");
    }
}
