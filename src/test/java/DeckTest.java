import cards.Card;
import cards.Deck;
import org.junit.Before;
import org.junit.Test;
import players.Player;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    Deck deck;
    Player player1;
    Player player2;

    @Before
    public void before(){
        deck = new Deck();
        player1 = new Player("Dan");
        player2 = new Player("Marcus");
    }


    @Test
    public void deckIsFull(){
        deck.generateDeck();
        assertEquals(52, deck.getDeckSize());
    }
}
