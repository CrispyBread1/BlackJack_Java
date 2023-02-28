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

//    Deals out cards to everyone

    public void shufflesDeck(){
        deck.generateDeck();
    }


    public void handCardsOut(Player player){
        for (int i = 0 ; i <= 2; i++){
            Random randomCardIndex = new Random();
            player.addCardToHand(deck.getRandomCard(randomCardIndex.nextInt(53)));
            handCardToSelf();
        }
    }

    public void handCardToSelf(){
        Random randomCardIndex = new Random();
        addCardToHand(deck.getRandomCard(randomCardIndex.nextInt(53)));
    }


//    Twist or stick or bust


    public void twist(Player player){
        Random randomCardIndex = new Random();
        player.twist(deck.getRandomCard(randomCardIndex.nextInt(53)));
    }

    public void dealerTwists(){
        Random randomCardIndex = new Random();
        twist(deck.getRandomCard(randomCardIndex.nextInt(53)));
    }

    public String checksForTwist(Player player){
        Boolean playerReady= false;
        while(!playerReady){
            player.playerTwistsORSticks();
            if (Objects.equals(player.getPlayersStickTwistBust(), "Twist")){
                twist(player);
            } else if (Objects.equals(player.getPlayersStickTwistBust(), "Stick")) {
                playerReady = true;
            } else if (Objects.equals(player.getPlayersStickTwistBust(), "Bust")) {
                playerReady = true;
            }
        } return player.getPlayersStickTwistBust();
    }

    public String checksSelfForTwist(){
        if (addHandValue() < 16){
            System.out.println(getPlayerName() + " is Twisting");
            dealerTwists();
        } else if (addHandValue() > 21){
            System.out.println(getPlayerName() + " is Bust");
            return "Bust";
        }
        System.out.println(getPlayerName() + " is Bust");
        return "Stick";
    }

}
