import blackjack.BlackJack;
import cards.Deck;
import org.junit.Before;
import org.junit.Test;
import players.Dealer;
import players.Player;

import static org.junit.Assert.assertEquals;

public class BlackJackTest {

    BlackJack blackJackGame;
    Deck deck;
    Player player;
    Dealer dealer;

    @Before
    public void before(){
        deck = new Deck();
        player = new Player("Dan");
        dealer = new Dealer("Marcus", deck);
        blackJackGame = new BlackJack(player, dealer);
    }



    @Test
    public void playersHaveCard(){
        blackJackGame.initiateGame();
        assertEquals(2, blackJackGame.getPlayerCardAmount());
    }

    @Test
    public void playersHasWon(){
        blackJackGame.initiateGame();
        assertEquals("Dan", blackJackGame.playTheGame());
    }



}
