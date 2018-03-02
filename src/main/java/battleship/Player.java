package battleship;

abstract class Player {

    //Player();

    public abstract void setName(String name);

    public abstract String getName();

    public abstract int potentialMove(int move);

    public abstract Board getBoard();

    public abstract int[][] getWinCombo();

    public abstract void setType(String type);

    public abstract String getType();
}
