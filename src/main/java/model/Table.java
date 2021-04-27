package model;

import java.util.List;
import java.util.Map;
import java.util.Set;
import libs.CircularList;
import model.card.Card;
import model.deck.IDeck;
import model.effects.Effect;

public interface Table {
    
    /**
     * @return deck
     */
    IDeck getDeck();
    
    /**
     * @return discard pile
     */
    List<Card> getDiscardPile();
    
    /**
     * @return a CircularList containing alive players
     */
    CircularList<Player> getPlayers();
    
    /**
     * Removes a player from a list of players
     * 
     * @param player the player to remove
     */
    void removePlayer(Player player);
    
    /**
     * @return current player
     */
    Player getCurrentPlayer();
    
    /**
     * Sets current player to the player passed as argument
     * 
     * @param player
     */
    void setCurrentPlayer(Player player);

    /**
     * Sets next player
     */
    void nextPlayer();

    TurnObservable<List<Player>> getChoosePlayersObservable();
    
    TurnObservable<Map<Card, Player>> getChooseCardsObservable();

    void choosePlayers(int howMany);
    
    void choosePlayers(int howMany, int distance);
    
    void chooseCards(List<Card> cardsToChoose, List<Player> choosers, int howManyPerPlayer);
    
    void playerUsedCard(String cardName);

    List<String> getPlayerUsedCards();
}
