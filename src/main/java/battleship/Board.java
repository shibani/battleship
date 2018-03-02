package battleship;

import java.util.ArrayList;

public class Board {

    private final int totalPositions;
    private ArrayList<String> positions = new ArrayList<String>();

    Board(){
        this.totalPositions = 100;
        this.setPositions();
    }

    public void setPositions(){
        int i = 0;
        while(i < this.totalPositions) {
            positions.add(" ");
            i++;
        }
    }

    public int getTotalPositions(){
        return this.totalPositions;
    }

    public ArrayList<String> getPositions(){
        return positions;
    }

    public boolean isEmpty(int position){
        if(this.getPositions().get(position).equals(" ")){
            return true;
        } else return false;
    }
}
