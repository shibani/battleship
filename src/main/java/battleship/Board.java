package battleship;

import java.util.ArrayList;

public class Board {

    private final int totalPositions;
    private ArrayList<Integer> positions = new ArrayList<Integer>();

    Board(){
        this.totalPositions = 100;
        this.setPositions();
    }

    public void setPositions(){
        int i = 0;
        while(i < this.totalPositions) {
            positions.add(i);
            i++;
        }
    }

    public int getTotalPositions(){
        return this.totalPositions;
    }

    public ArrayList<Integer> getPositions(){
        return positions;
    }

    public void sankShip(){
        //TODO "You sank my battleship!"
    }

    public void won(){
        //TODO All enemy ships were sunk
    }

    public boolean isEmpty(int position){
        if(this.getPositions().get(position) != "X" || "O" ){
            return true;
        } else {
            return false;
        }
    }
}
