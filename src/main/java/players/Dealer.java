package players;

import cards.Deck;

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

    public void handCardToSelf(){
        Random randomCardIndex = new Random();
        addCardToHand(deck.getRandomCard(randomCardIndex.nextInt(53)));
    }

}
