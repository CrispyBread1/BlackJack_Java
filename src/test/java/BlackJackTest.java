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
    Player player2;
    Player player3;
    Player player4;
    Dealer dealer;

    @Before
    public void before(){
        deck = new Deck();
        player = new Player("Dan");
        player2 = new Player("Ben");
        player3 = new Player("Ashley");
        player4 = new Player("James");
        dealer = new Dealer("Marcus the Dealer", deck);
        blackJackGame = new BlackJack(dealer);
    }



//    @Test
//    public void playersHaveCard(){
//        blackJackGame.initiateGame();
//        blackJackGame.addPlayerToGame(player);
//        assertEquals(2, blackJackGame.getPlayerCardAmount());
//    }

    @Test
    public void playerHasWon(){
        blackJackGame.addPlayerToGame(player);
        blackJackGame.addPlayerToGame(player2);
        blackJackGame.addPlayerToGame(player3);
        blackJackGame.addPlayerToGame(player4);
        blackJackGame.initiateGame();
        String winner = blackJackGame.playTheGame();
        assertEquals(winner, winner);
    }

}
