package blackjack;

import players.Dealer;
import players.Player;

import java.util.ArrayList;
import java.util.Objects;


public class BlackJack {

    private ArrayList<Player> players;
    private Dealer dealer;


    public BlackJack( Dealer dealer){
        this.players = new ArrayList<>();
        this.dealer = dealer;
    }


// Initiates the game

    public void addPlayerToGame(Player player){
        players.add(player);
    }


    public void initiateGame(){
        dealer.shufflesDeck();
        for (Player player: players){
            dealer.handCardsOut(player);
        }
    }


// Play the game


    public String playTheGame() {
        for (Player player : players) {
            dealer.checksForTwist(player);
        }
        return getWinner();
    }

    public String getWinner(){
        ArrayList<String> highestScorePlayerName = new ArrayList<>();
        int highestScore = 0;

        if (Objects.equals(dealer.checksSelfForTwist(), "Stick")){
            highestScorePlayerName.add(dealer.getPlayerName());
            highestScore = dealer.addHandValue();
        }

        // compares scores, if dealer is not bust the score all the players will compare against is the dealers.

        for (Player player : players){
            if (Objects.equals(player.getPlayersStickTwistBust(), "Stick") && player.addHandValue() > highestScore){
                highestScorePlayerName = new ArrayList<>();
                highestScorePlayerName.add(player.getPlayerName());
                highestScore = player.addHandValue();
            } else if (Objects.equals(player.getPlayersStickTwistBust(), "Stick") && player.addHandValue() == highestScore){
                highestScorePlayerName.add(player.getPlayerName());
            }
        }

        // returns winner

        if (highestScore == 0){
            System.out.println("All players are BUST");
            return "All players are BUST";
        } else if (highestScorePlayerName.size() > 1){
            System.out.println("There is a " + highestScorePlayerName.size() + " way TIE!!");
            return "There is a " + highestScorePlayerName.size() + " way TIE!!";
        }
        System.out.println(highestScorePlayerName.get(0) + " WON!!");
        return highestScorePlayerName.get(0) + " WON!!";
    }


}
