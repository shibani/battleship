package battleship;

public class Computer extends Player {

    String name;
    String type;
    String marker;
    Board board = new Board();
    int[][] winCombo = new int[5][];

    Computer(){
        this.board = board;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setMarker(String marker){
        this.marker = marker;
    }

    public String getMarker(){
        return this.marker;
    }

    public int potentialMove(int move){
        return move;
    }

    public Board getBoard(){
        return board;
    }

    public int[][] getWinCombo(){
        int[] array1 = new int[]{1, 2};
        int[] array2 = new int[]{17, 18, 19};
        int[] array3 = new int[]{83, 84, 85};
        int[] array4 = new int[]{35, 45, 55, 65};
        int[] array5 = new int[]{38, 48, 58, 68, 78};
        winCombo[0] = array1;
        winCombo[1] = array2;
        winCombo[2] = array3;
        winCombo[3] = array4;
        winCombo[4] = array5;
        return winCombo;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }
}
