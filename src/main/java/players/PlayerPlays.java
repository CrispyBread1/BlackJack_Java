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

    public String getPlayerName(){
        return this.name;
    }

    public void addCardToHand(Card card) {
        if (hand.size() < 2) {
            hand.add(card);
        }
    }

    public void twist(Card card){
        hand.add(card);
    }

    public int getHandAmount(){
        return hand.size();
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

    public ArrayList<Card> getHand(){
        return hand;
    }

    public String twistWithACE(Card card){
        System.out.println(getPlayerName() + " has an ACE");
        int handValueWithOne = addHandValue();
        card.changeToEleven();
        int handValueWithEleven = addHandValue();
        if (handValueWithEleven > handValueWithOne && handValueWithEleven < 14){
            System.out.println(getPlayerName() + " is Twisting and Ace is now 11");
            return "Twist";
        } else if (handValueWithEleven > handValueWithOne && handValueWithEleven > 14 && handValueWithEleven <= 21){
            System.out.println(getPlayerName() + " is Sticking with ace as 11");
            return "Stick";
        } else  if (handValueWithEleven > 21){
            card.changeToOne();
            if (addHandValue() < 21){
                System.out.println(getPlayerName() + " is Stikcing with ace value 1 as ace value 11 total is over 21");
                return "Stick";
            }
            System.out.println(getPlayerName() + " is Bust with ace 11 or 1");
            return "Bust";

        }
        System.out.println(getPlayerName() + " is Sticking with ace as 11");
        return "Stick";

    }


}
