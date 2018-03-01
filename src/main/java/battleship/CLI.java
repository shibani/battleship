package battleship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CLI {

    public static final HashMap<Integer, String> gameTypeChoices = new HashMap<Integer, String>();
    public static final HashMap<Integer, String> firstPlayer = new HashMap<Integer, String>();

    static {
        gameTypeChoices.put(1, "Human vs. Computer");
        gameTypeChoices.put(2, "Computer vs. Computer");
        gameTypeChoices.put(3, "Human vs. Human");
    }

    static {
        firstPlayer.put(1, "User");
        firstPlayer.put(2, "Opponent");
    }

    public void welcome() throws IOException {
        System.out.println("Welcome to Battleship");
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

        return Integer.parseInt(input);
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

        return Integer.parseInt(input);
    }

    public void confirmPlayerSelection(int selection){

        System.out.println("You selected: " + selection + ". " + firstPlayer.get(selection) + " goes first.\n");
    }

    public void printBoard(Board board) {

        ArrayList<Integer> positions = board.getPositions();

        int i = 0;

        String border = " +=====+=====+=====+=====+=====+=====+=====+=====+=====+=====+ ";

        System.out.println(border);
        System.out.print(" | ");

        while(i < board.getTotalPositions()) {
            System.out.print((positions.get(i)/10) + "," + (positions.get(i) % 10) + " | ");
            if(i % 10 == 9){
                System.out.print("\n");
                System.out.println(border);
                if(i != board.getTotalPositions() - 1){
                    System.out.print(" | ");
                }
            }
            i++;
        }
    }

    public int coordsToPosition(String coords){
        String[] coordsArray = coords.split(",");
        int position = Integer.parseInt(coordsArray[0]) * 10 + Integer.parseInt(coordsArray[1]);
        return position;
    }

    public void announcePlayer1Turn(Game game){
        System.out.println("Player 1 is " + game.getPlayersArray()[0].getClass().getName() + ". " +
                game.getPlayer1().getClass().getName() + " goes first:");

        System.out.println("Player 1's board");
        System.out.println("Enter your move with one digit for the row and one digit for the column separated by a comma");
    }

    public String getMove() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        return input;
    }
}
