package battleship;

import java.util.ArrayList;

public class Game {

    private Board board;

    private ArrayList<Player> players = new ArrayList<Player>();

    Game(Board board){
        this.board = board;
    }

    public Board getBoard(){
        return board;
    }


}
