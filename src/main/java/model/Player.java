package model;

import java.util.List;

import model.card.Card;

public interface Player {
    
	/**
	 * 
	 * @return useBang
	 */
	public boolean getUSeBang();
	/**
	 * @param b
	 */
	public void setUseBang(boolean b); 
     /**
      ** @return player name
      */
     public String getName();

    /**
     * this method set the sight of the sight of the player
     * @param sight
     */
    public void setRange(final int sight);

    /**
     * @return the sight
     */
    public int getSight();

    /**
     * @return the role of the player
     */
    public Role getRole();

    /**
     * @return a list containing the hand of card of the player
     */
    public List<Card> getCards();
	
    /**
     * this method is use to add a card in the hand of player
     * @param card
     */
    public void addCard(final Card card);

    /**
     * Removes a card from the hand of the player
     * @param card
     */
    public void removeCard(final Card card);
	
    /**
     * @return a list containing the active cards of the player
     */
    public List<Card> getActiveCards();
        
    /**
     * Adds a card to the active cards
     * @param card
     */
    public void addActiveCard(final Card card);
        
    /**
     * Removes a card from the active cards of the player
     * @param card
     */
    public void removeActiveCard(final Card card);
	
    /**
     * this method is use to see the remaining life point of the player
     * @return lifePoints
     */
    public int getLifePoints();

    /**
     * this method is use to add or remove lifePoints of the player
     */
    public void modifyLifePoints(final int points);

    int getRetreat();

    List<Card> getCardsByName(final String name);
    
    List<Card> getActiveCardsByName(final String name);

    void playCard(final String name, final Table table);

    void modifySight(final int sight);

    void modifyRetreat(final int retreat);

    void addProtection();

    void removeProtection();

    boolean hasProtection();
}
