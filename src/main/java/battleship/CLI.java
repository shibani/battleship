package battleship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CLI {

    private static final HashMap<Integer, String> gameTypeChoices = new HashMap<Integer, String>();

    static {
        gameTypeChoices.put(1, "Human vs. Computer");
        gameTypeChoices.put(2, "Computer vs. Computer");
        gameTypeChoices.put(3, "Human vs. Human");
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
        System.out.println("Next please select who should go first, enter 1 for Human or 2 for Computer");
    }

    public int getPlayerSelection() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        return Integer.parseInt(input);
    }

    public void confirmPlayerSelection(int selection){

        String firstPlayer = (selection == 1) ? "Human Player" : "Computer Player";
        System.out.print("You selected: " + selection + ". " + firstPlayer + " goes first.");
    }
}
