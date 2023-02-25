package players;

import cards.Deck;

import java.util.Objects;
import java.util.Random;

public class Dealer extends PlayerPlays{

    private String name;
    private Deck deck;

    public Dealer(String name, Deck deck){
        super(name);
        this.deck = deck;
    }

    public void handCardsOut(Player player){
        deck.generateDeck();
        for (int i = 0 ; i <= 2; i++){
            Random randomCardIndex = new Random();
            player.addCardToHand(deck.getRandomCard(randomCardIndex.nextInt(53)));
            handCardToSelf();
        }
    }

    public void twist(Player player){
        Random randomCardIndex = new Random();
        player.twist(deck.getRandomCard(randomCardIndex.nextInt(53)));
    }

    public void dealerTwists(){
        Random randomCardIndex = new Random();
        twist(deck.getRandomCard(randomCardIndex.nextInt(53)));
    }


    public void handCardToSelf(){
        Random randomCardIndex = new Random();
        addCardToHand(deck.getRandomCard(randomCardIndex.nextInt(53)));
    }

    public String checksForTwist(Player player){
        Boolean playerReady= false;
        while(!playerReady){
            if (Objects.equals(player.playerTwistsORSticks(), "Twist")){
                twist(player);
            } else if (Objects.equals(player.playerTwistsORSticks(), "Stick")) {
                playerReady = true;
            } else if (Objects.equals(player.playerTwistsORSticks(), "Bust")) {
                playerReady = true;
            }
        } return player.playerTwistsORSticks();
    }

    public String checksSelfForTwist(){
        if (addHandValue() < 16){
            dealerTwists();
        } else if (addHandValue() > 21){
            return "Bust";
        } return "Stick";
    }

}
