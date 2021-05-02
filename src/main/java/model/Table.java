package model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import libs.CircularList;
import model.card.Card;
import model.deck.IDeck;

public interface Table {

    enum Message {
        CHOOSE_PLAYER, CHOOSE_PLAYER_WITH_DISTANCE, CHOOSE_CARD
    }

    /**
     * Returns the deck.
     * 
     * @return deck
     */
    IDeck getDeck();

    /**
     * Returns a list containing all discarded cards.
     * 
     * @return discard pile
     */
    List<Card> getDiscardPile();
    
    /**
     * Adds a card to the discard pile.
     * 
     * @param card
     */
    void discardCard(final Card card);

    /**
     * Returns a list of alive players.
     * 
     * @return a CircularList of players
     */
    CircularList<Player> getPlayers();

    /**
     * Removes a player from a list of players.
     * 
     * @param player
     */
    void removePlayer(final Player player);

    /**
     * Returns the current player.
     * 
     * @return current player
     */
    Player getCurrentPlayer();

    /**
     * Sets the current player.
     * 
     * @param player
     */
    void setCurrentPlayer(Player player);

    /**
     * Sets next player
     */
    void nextPlayer();

    /**
     * Returns the turn observable.
     * 
     * @return turn observable
     */
    TurnObservable<Player> getChoosePlayerObservable();

    /**
     * Returns a turnObservable containing 
     * 
     * @return
     */
    TurnObservable<Map<Card, Player>> getChooseCardsObservable();

    void choosePlayer(Set<Player> chosenPlayerList);

    void chooseCards(List<Card> cardsToChoose, List<Player> choosers, int howManyPerPlayer);

    void playerUsedCard(String cardName);

    List<String> getPlayerUsedCards();

    Message getMessage();

    void setMessage(Message message);

    int getHowMany();

    List<Card> getCardsToChoose();

    List<Player> getChoosers();

    int getHowManyPerPlayer();

    Set<Player> getChosenPlayerList();
}
