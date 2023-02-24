package players;

import cards.Card;

import java.util.ArrayList;

public abstract class PlayerPlays {

    private ArrayList<Card> hand;
    private String name;

    private int win;
    private int loss;

    public PlayerPlays(String name) {
        this.hand = new ArrayList<>();
        this.name = name;
        this.win = 0;
        this.loss = 0;
    }

    public void addCardToHand(Card card) {
        if (hand.size() < 2) {
            hand.add(card);
        }
    }

    public int getHandAmount(){
        return hand.size();
    }

    public String getPlayerName(){
        return this.name;
    }

    public void wonGame(){
        this.win += 1;
    }

    public void lostGame(){
        this.loss += 1;
    }

    public int getWinAmount(){
        return this.win;
    }

    public int getLossAmount(){
        return this.loss;
    }

    public int addHandValue(){
        int handValue = 0;
        for (Card card : hand){
            handValue += card.getValue();
        }
        return handValue;
    }
}
