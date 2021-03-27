package model;

import java.util.Set;

public interface Table {
    
    /**
     * @return deck
     */
    Deck getDeck();
    
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
     * Current player draws cards
     * 
     * @param nCards the number of cards to draw
     */
    void drawCards(int nCards);
    
    /**
     * Performs an action on a target player
     * 
     * @param action the action to be executed
     * @param targets the targets of the action
     */
    void action(Action action, Set<Player> targets);
    
    /**
     * @return next player
     */
    Player getNextPlayer();
    
    /**
     * Checks if the game is over
     */
    boolean isOver();
    
}
