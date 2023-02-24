import blackjack.BlackJack;
import cards.Deck;
import org.junit.Before;
import org.junit.Test;
import players.Player;

import static org.junit.Assert.assertEquals;

public class BlackJackTest {

    BlackJack blackJackGame;
    Deck deck;
    Player player1;
    Player player2;

    @Before
    public void before(){
        deck = new Deck();
        player1 = new Player("Dan");
        player2 = new Player("Marcus");
        blackJackGame = new BlackJack(deck);
    }

    @Test
    public void gameHasPlayers(){
        blackJackGame.initiateGame(player1, player2, deck);
        assertEquals(2, blackJackGame.getPlayersAmount());
    }

    @Test
    public void deckIsFullOfCards(){
        blackJackGame.initiateGame(player1, player2, deck);
        assertEquals(52, blackJackGame.getDeckCardAmount());
    }

    @Test
    public void playersHaveCard(){
        blackJackGame.initiateGame(player1, player2, deck);
        assertEquals(2, blackJackGame.getPlayerCardAmount(player1));
    }

    @Test
    public void playersHasWon(){
        blackJackGame.initiateGame(player1, player2, deck);
        assertEquals("Dan", blackJackGame.playTheGame());
    }



}
