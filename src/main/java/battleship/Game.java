package battleship;

public class Game {

    Player player1;
    Player player2;
    private Player currentPlayer;

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
            if(CLI.gameTypeChoices.get(choice).equals("Human vs. Computer")){
                this.player1 = new Computer();
                this.player2 = new Human();
            } else if (CLI.gameTypeChoices.get(choice).equals("Computer vs. Computer")){
                this.player1 = new Computer();
                this.player2 = new Computer();
            } else if (CLI.gameTypeChoices.get(choice).equals("Human vs. Human")){
                this.player1 = new Human();
                this.player2 = new Human();
            }
            this.player1.setType("Opponent");
            this.player2.setType("User");
        }

        this.player1.setName("Player 1");
        this.player2.setName("Player 2");
        this.setCurrentPlayer();
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

    public String makeMove(int moveToBoard){
        String gameStatus;
        if(this.isWon()){
            gameStatus = "won";
        } else {
            gameStatus = this.shipIsHit(moveToBoard);
            if (gameStatus.equals("miss")) {
                this.getCurrentPlayer().getBoard().getPositions().set(moveToBoard, "n");
            }
        }
        return gameStatus;
    }

    public String shipIsHit(int position) {
        String shipStatus = "";
        Boolean shipInArray = false;
        outerLabel:
        if (shipStatus.trim().length() == 0 || shipStatus.equals("miss")){
            for (String[] ship : this.getCurrentPlayer().getWinCombo()) {
                int hitCount = 0;
                for (int i = 0; i < ship.length; i++) {
                    String el = (this.getCurrentPlayer().getBoard().getPositions().get(Integer.parseInt(ship[i])));
                    if (el.equals("X")){
                        hitCount++;
                    } else if (Integer.parseInt(ship[i]) == position) {
                        this.getCurrentPlayer().getBoard().getPositions().set(position, "X");
                        hitCount++;
                        shipInArray = true;
                    }
                    if (i + 1 == ship.length){
                        if(hitCount == ship.length && shipInArray){
                            shipStatus = "sunk";
                            break outerLabel;
                        } else if(hitCount > 0 && shipInArray){
                            shipStatus = "hit";
                            break outerLabel;
                        } else {
                            shipStatus = "miss";
                        }
                    }
                }
            }
        }
        return shipStatus;
    }

    public boolean isWon() {
        int hitCount = 0;
        for(String el : this.getCurrentPlayer().getBoard().getPositions()){
            if(el.equals("X")) {
                hitCount++;
            }
        }

        return hitCount == this.getCurrentPlayer().maxPossibleHits();
    }
}
