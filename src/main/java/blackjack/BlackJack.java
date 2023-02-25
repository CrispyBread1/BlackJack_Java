package blackjack;

import players.Dealer;
import players.Player;

import java.util.Objects;


public class BlackJack {

    private Player player;
    private Dealer dealer;


    public BlackJack(Player player, Dealer dealer){
        this.player = player;
        this.dealer = dealer;
    }


// Initiates the game


    public void initiateGame(){
        dealer.handCardsOut(player);
    }


// Play the game


    public String playTheGame(){
        String playerChoice;
        String dealerChoice;
        playerChoice = dealer.checksForTwist(player);
        dealerChoice = dealer.checksSelfForTwist();

        if (Objects.equals(playerChoice, "Stick")&& Objects.equals(dealerChoice, "Stick")){
            if (player.addHandValue() > dealer.addHandValue()){
            return player.getPlayerName();
            } else return dealer.getPlayerName();
        } else if (Objects.equals(playerChoice, "Bust")){
            return dealer.getPlayerName();
        } return player.getPlayerName();


    }


// Gets for tests


    public int getPlayerCardAmount(){
        return player.getHandAmount();
    }



}
