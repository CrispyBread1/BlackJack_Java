package players;

import cards.Card;

import java.util.ArrayList;

public class Player extends PlayerPlays {

    private String name;

    private String playerChoice;

    public Player(String name){
        super(name);
    }

    public void playerTwistsORSticks(){
        for (Card card : getHand()){
            if (card.getValue() == 1){
                playerChoice = twistWithACE(card);
            }
        }
        if (addHandValue() < 14){
            System.out.println(getPlayerName() + " is Twisting");
            playerChoice = "Twist";
        } else if (addHandValue() > 21) {
            System.out.println(getPlayerName() + " is Bust");
            playerChoice = "Bust";
        }
        System.out.println(getPlayerName() + " is Sticking");
        playerChoice = "Stick";
    }

    public String getPlayersStickTwistBust(){
        return playerChoice;
    }

}

