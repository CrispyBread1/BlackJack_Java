package players;

import cards.Card;

import java.util.ArrayList;

public class Player extends PlayerPlays {

    String name;

    public Player(String name){
        super(name);
    }

    public String playerTwistsORSticks(){
        if (addHandValue() < 14){
            return "Twist";
        } else if (addHandValue() > 21) {
            return "Bust";
        } return "Stick";
    }

}

