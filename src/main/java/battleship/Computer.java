package battleship;

public class Computer extends Player {

    private String name;
    private String type;
    private Board board;
    int maxPossibleHits;
    private String[][] winCombo = {
            {"1", "2"},
            {"17", "18", "19"},
            {"83", "84", "85"},
            {"35", "45", "55", "65"},
            {"38", "48", "58", "68", "78"}
    };

    Computer(){}

    @Override
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public int potentialMove(int move){
        return move;
    }

    @Override
    public Board getBoard(){
        return board;
    }

    @Override
    public void setType(String type){
        this.type = type;
    }

    @Override
    public String getType(){
        return this.type;
    }

    @Override
    public void setWinCombo(int i, int j, String marker){
        winCombo[i][j] = marker;
    }

    @Override
    public String[][] getWinCombo(){
        return winCombo;
    }

    @Override
    public int maxPossibleHits() {
        int count = 0;
        for(String[] array : this.getWinCombo()){
            count += array.length;
        }
        return count;
    }
}
