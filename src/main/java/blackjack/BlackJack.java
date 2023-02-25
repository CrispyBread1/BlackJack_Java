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
        playerChoice = dealer.checksForTwist(player);
        System.out.println(playerChoice);
        if (Objects.equals(playerChoice, "Stick")){
            if (player.addHandValue() > dealer.addHandValue()){
            return player.getPlayerName();
            } else return dealer.getPlayerName();
        } else return dealer.getPlayerName();

    }


// Gets for tests


    public int getPlayerCardAmount(){
        return player.getHandAmount();
    }



}
