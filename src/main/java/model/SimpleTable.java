package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import libs.CircularList;
import model.card.Card;
import model.deck.IDeck;

public class SimpleTable implements Table{
    private static final List<Role> totalRoles = List.of(
        Role.SHERIFF,Role.RENEGADE,Role.OUTLAW,Role.OUTLAW,Role.DEPUTY,Role.OUTLAW,Role.OUTLAW);
    
    private IDeck deck;
    private List<Card> discardPile = new ArrayList<>();
    private CircularList<Player> players;
    private Player currentPlayer;
    private List<String> usedCards = new ArrayList<>();
    
    private TurnObservable<Player> choosePlayerObservable = new TurnObservable<>();
    private TurnObservable<Map<Card, Player>> chooseCardsObservable = new TurnObservable<>();
	private int howMany;
	private Message message = null;
	private Set<Player> chosenPlayerSet;
	private List<Card> cardsToChoose;
	private List<Player> choosers;
	private int howManyPerPlayer;
    
    public SimpleTable(final IDeck deck, final int numberOfPlayers) {
        this.deck = deck;
        this.players = getPlayersFromNumber(numberOfPlayers);
        this.getFirstCards();
        this.currentPlayer = this.players.getCurrentElement();
    }

    private CircularList<Player> getPlayersFromNumber(final int playerNumber){
        List<Role> roles = new ArrayList<>(totalRoles.subList(0, playerNumber));
        Collections.shuffle(roles);
        //CircularList<Player> c = new CircularList<>(roles.stream().map(r -> new SimplePlayer(r, "player " + Integer.toString(roles.indexOf(r))))
        //.collect(Collectors.toList()));
        CircularList<Player> c = new CircularList<>();
        for (int i = 0; i < playerNumber; i++) {
            c.add(new SimplePlayer(roles.get(i), "player " + i));
        }
        
        int pos = c.indexOf(c.stream().filter(p -> p.getRole() == Role.SHERIFF).findFirst().get());
        c.setCurrentIndex(pos);
        return c;
    }

    private void getFirstCards() {
        this.players.forEach(p -> {
            this.deck.nextCards(p.getLifePoints()).forEach(c -> p.addCard(c));
        });
    }
    
    @Override
    public IDeck getDeck() {
        return this.deck;
    }
    
    @Override
    public List<Card> getDiscardPile() {
        return this.discardPile;
    }
    
    @Override
    public void discardCard(final Card card) {
        this.discardPile.add(card);
    };

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
    public void nextPlayer() {
        this.usedCards.clear();
        this.setCurrentPlayer(players.getNext());
    }

    @Override
    public TurnObservable<Player> getChoosePlayerObservable() {
        return this.choosePlayerObservable;
    }

    @Override
    public TurnObservable<Map<Card, Player>> getChooseCardsObservable() {
        return this.chooseCardsObservable;
    }

    @Override
    public void choosePlayer(Set<Player> chosenPlayerSet) {
    	this.message = Message.CHOOSE_PLAYER;
    	this.chosenPlayerSet = chosenPlayerSet;
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
    
    @Override
    public Message getMessage() {
        return this.message;
    }
    
    @Override
    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public Set<Player> getChosenPlayerList() {
        return this.chosenPlayerSet;
    }

    @Override
    public int getHowMany() {
        return howMany;
    }

    @Override
    public List<Card> getCardsToChoose() {
        return cardsToChoose;
    }

    @Override
    public List<Player> getChoosers() {
        return choosers;
    }

    @Override
    public int getHowManyPerPlayer() {
        return howManyPerPlayer;
    }
}
