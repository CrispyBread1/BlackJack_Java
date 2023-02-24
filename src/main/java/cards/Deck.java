package cards;
import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> deck;

    public Deck(){
        this.deck = new ArrayList<>();
    }

    public void generateDeck() {
        int[] values;
        values = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        String[] suits;
        suits = new String[]{"Club", "Spade", "Diamond", "Heart"};
        for (int number : values) {
            for (String name : suits) {
                Card card = new Card(name, number);
                deck.add(card);
            }
        }
    }

    public  int getDeckSize(){
        return deck.size();
    }

    public Card getRandomCard(int index){
        if (index == 53){
            return deck.get(0);
        }
        return deck.get(index);
    }



}
