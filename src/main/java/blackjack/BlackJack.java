package blackjack;

import cards.Deck;
import players.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class BlackJack {

    private ArrayList<Player> players;
    private Deck deck;

    public BlackJack(Deck deck){
        this.players = new ArrayList<>();
    }


// Initiates the game


    public void initiateGame(Player player1, Player player2, Deck deck){
        this.deck = deck;
        addPlayersToGame(player1, player2);
        getDeck();
        for (int i = 0 ; i <= 2; i++){
            addCardsToplayer();
        }
    }

    public void addPlayersToGame(Player player1, Player player2){
        if (players.size() < 2) {
            players.add(player1);
            players.add(player2);
        }
    }

    public void addCardsToplayer(){
        for (Player player : players){
            Random randomCardIndex = new Random();
            player.addCardToHand(deck.getRandomCard(randomCardIndex.nextInt(53)));
        }
    }


// Play the game


    public String playTheGame(){
        HashMap<Integer, String> playersHandValues = new HashMap<>();
        int topScore = 0;
        for (Player player : players){
            if (player.addHandValue() > topScore){
                topScore = player.addHandValue();
            }
            playersHandValues.put(player.addHandValue(), player.getPlayerName());
        }
        return playersHandValues.get(topScore);
    }


// All the gets for tests


    public int getPlayerCardAmount(Player player){
        int playerIndex =  this.players.indexOf(player);
        Player playerToSeeCardAmount = this.players.get(playerIndex);
        return playerToSeeCardAmount.getHandAmount();
    }

    public int getPlayersAmount(){
        return players.size();
    }


    public int getDeckCardAmount() {
        return deck.getDeckSize();
    }

    public void getDeck(){
        deck.generateDeck();
    }


}
