package cards;



public class Card {

    private String suit;
    private int value;

    public Card (String suit, int value){
        this.suit = suit;
        this.value = value;
    }

    public String getSuit(){
        return this.suit;
    }

    public int getValue(){
        return this.value;
    }

    public void changeToEleven(){
        this.value = 11;
    }

    public void changeToOne(){
        this.value = 1;
    }


}
