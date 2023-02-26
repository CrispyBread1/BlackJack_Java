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
        if (addHandValue() < 14){
            playerChoice = "Twist";
        } else if (addHandValue() > 21) {
            playerChoice = "Bust";
        } playerChoice = "Stick";
    }

    public String getPlayersStickTwistBust(){
        return playerChoice;
    }
}

