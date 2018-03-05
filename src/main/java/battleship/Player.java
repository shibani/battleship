package battleship;

abstract class Player {

    public abstract void setName(String name);

    public abstract String getName();

    public abstract int potentialMove(int move);

    public abstract Board getBoard();

    public abstract void setWinCombo(int i, int j, String marker);

    public abstract String[][] getWinCombo();

    public abstract void setType(String type);

    public abstract String getType();

    public abstract int maxPossibleHits();
}
