package battleship;

public class Game {

    Player player1;
    Player player2;
    Player currentPlayer;
    Player[] players = new Player[2];

    Game(){}

    public void createPlayers(int choice, int firstPlayer) {
        if(CLI.firstPlayer.get(firstPlayer).equals("User")){
            if(CLI.gameTypeChoices.get(choice).equals("Human vs. Computer")){
                this.player1 = new Human();
                this.player2 = new Computer();
            } else if (CLI.gameTypeChoices.get(choice).equals("Computer vs. Computer")){
                this.player1 = new Computer();
                this.player2 = new Computer();
            } else if (CLI.gameTypeChoices.get(choice).equals("Human vs. Human")){
                this.player1 = new Human();
                this.player2 = new Human();
            }
            this.player1.setType("User");
            this.player2.setType("Opponent");
        } else {
            String secondPlayer = "User";
            if(CLI.gameTypeChoices.get(choice).equals("Human vs. Computer")){
                this.player1 = new Computer();
                this.player2 = new Human();
            } else if (CLI.gameTypeChoices.get(choice).equals("Computer vs. Computer"){
                this.player1 = new Computer();
                this.player2 = new Computer();
            } else if (CLI.gameTypeChoices.get(choice).equals("Human vs. Human")){
                this.player1 = new Human();
                this.player2 = new Human();
            }
            this.player1.setType("Opponent");
            this.player2.setType("User");
        }

        this.setPlayersArray(this.player1, this.player2);
        this.player1.setName("Player 1");
        this.player2.setName("Player 2");
        this.setCurrentPlayer();
    }

    public void setPlayersArray(Player player1, Player player2){
        this.players[0] = player1;
        this.players[1] = player2;
    }

    public Player[] getPlayersArray(){
        return this.players;
    }

    public Player getPlayer1(){
        return this.player1;
    }

    public Player getPlayer2(){
        return this.player2;
    }

    public void setCurrentPlayer(){
        if(this.currentPlayer == this.getPlayer1()){
            this.currentPlayer = this.getPlayer2();
        }else if(this.currentPlayer == this.getPlayer2()){
            this.currentPlayer = this.getPlayer1();
        }else if(this.currentPlayer == null){
            this.currentPlayer = this.getPlayer1();
        }
    }

    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }

    public void makeMove(int moveToBoard){
        // if this is a win combo number mark the spot X
        // if all other win combos are X/gameOver check returns true, call Cli.won
        // else if all other numbers in the combo are X
        // call Cli.sankship
        // else call Cli.hit
        // else mark it n
        // call Cli.miss
        this.getCurrentPlayer().getBoard().getPositions().set(moveToBoard, "X");
    }

    public boolean shipIsHit(int position){
        return false;
    }

    public boolean ShipIsSunk() {
        return false;
    }

    public boolean IsWon() {
        return false;
    }
}
