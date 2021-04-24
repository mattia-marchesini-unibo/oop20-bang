package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.card.Card;
import model.deck.IDeck;
import model.effects.Effect;
import libs.CircularList;

enum Message{
	 CHOOSE_PLAYER, CHOOSE_PLAYER_WITH_DISTANCE, CHOOSE_CARD
}

public class SimpleTable implements Table{
    
    private IDeck deck;
    private List<Card> discardPile;
    private CircularList<Player> players;
    private Player currentPlayer;
    private List<String> usedCards = new ArrayList<>();
    
    private TurnObservable<List<Player>> choosePlayersObservable = new TurnObservable<>();
    private TurnObservable<Map<Card, Player>> chooseCardsObservable = new TurnObservable<>();
	private int howMany;
	private Message message;
	private int distance;
	private List<Card> cardsToChoose;
	private List<Player> choosers;
	private int howManyPerPlayer;
    
    public SimpleTable(final IDeck deck, final CircularList<Player> players) {
        this.deck = deck;
        this.players = players;
        this.currentPlayer = players.getCurrentElement();
    }

    @Override
    public IDeck getDeck() {
        if(this.deck.remainigCards() == 0) {
            this.deck.getCards().addAll(this.discardPile);
            this.deck.shuffleDeck();
            this.discardPile.clear();
        }
        return this.deck;
    }
    
    @Override
    public List<Card> getDiscardPile() {
        return this.discardPile;
    }

    @Override
    public CircularList<Player> getPlayers() {
        return this.players;
    }

    @Override
    public void removePlayer(Player player) {
        players.remove(player);
    }

    @Override
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }
    
    @Override
    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

    @Override
    public void drawCards(int nCards) {
        
    }

    @Override
    public void action(Effect effects, Set<Player> targets) {
        // TODO Auto-generated method stub
    }

    @Override
    public void nextPlayer() {
        this.setCurrentPlayer(players.getNext());
    }

    @Override
    public TurnObservable<List<Player>> getChoosePlayersObservable() {
        return this.choosePlayersObservable;
    }

    @Override
    public TurnObservable<Map<Card, Player>> getChooseCardsObservable() {
        return this.chooseCardsObservable;
    }

    @Override
    public void choosePlayers(int howMany) {
    	this.howMany = howMany;
    	this.message = Message.CHOOSE_PLAYER;
    }

    @Override
    public void choosePlayers(int howMany, int distance) {
    	this.howMany = howMany;
    	this.distance = distance;
    	this.message = Message.CHOOSE_PLAYER_WITH_DISTANCE;
    }

    @Override
    public void chooseCards(List<Card> cardsToChoose, List<Player> choosers, int howManyPerPlayer) {
    	this.cardsToChoose = cardsToChoose;
    	this.choosers = choosers;
    	this.howManyPerPlayer = howManyPerPlayer;
    	this.message = Message.CHOOSE_CARD;
    }

    @Override
    public void playerUsedCard(String cardName) {
        this.usedCards.add(cardName);
    }

    @Override
    public List<String> getPlayerUsedCards() {
        return this.usedCards;
    }
}
