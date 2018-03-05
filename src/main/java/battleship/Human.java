package battleship;

public class Human extends Player {

    private String name;
    private String type;
    private Board board = new Board();
    int maxPossibleHits;
    private String[][] winCombo = {
            {"1", "2"},
            {"17", "18", "19"},
            {"83", "84", "85"},
            {"35", "45", "55", "65"},
            {"38", "48", "58", "68", "78"}
    };


    Human(){
        this.board = board;
    }

    @Override
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public Board getBoard(){
        return board;
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
    public void setType(String type){
        this.type = type;
    }

    @Override
    public String getType(){
        return this.type;
    }

    @Override
    public int maxPossibleHits() {
        int count = 0;
        for(String[] array : this.getWinCombo()){
            count += array.length;
        }
        return count;
    }

    @Override
    public int potentialMove(int move){
        return move;
    }
}
