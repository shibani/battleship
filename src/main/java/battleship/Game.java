package battleship;

public class Game {

    Player player1;
    Player player2;
    Player[] players = new Player[2];

    Game(){}

    public void createPlayers(String choice, String firstPlayer) {
        if(firstPlayer == "User"){
            if(choice == "Human vs. Computer"){
                this.player1 = new Human();
                this.player2 = new Computer();
            } else if (choice == "Computer vs. Computer"){
                this.player1 = new Computer();
                this.player2 = new Computer();
            } else if (choice == "Human vs. Human"){
                this.player1 = new Human();
                this.player2 = new Human();
            }
        } else {
            String secondPlayer = "User";
            if(choice == "Human vs. Computer"){
                this.player1 = new Computer();
                this.player2 = new Human();
            } else if (choice == "Computer vs. Computer"){
                this.player1 = new Computer();
                this.player2 = new Computer();
            } else if (choice == "Human vs. Human"){
                this.player1 = new Human();
                this.player2 = new Human();
            }
        }

        this.setPlayersArray(this.player1, this.player2);
        this.player1.setName("Player 1");
        this.player1.setMarker("X");

        this.player2.setName("Player 2");
        this.player2.setMarker("O");
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
}
