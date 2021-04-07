package model;

import java.util.List;

public interface Player {
	
	/**
	 * this method set the sight of the sight of the player
	 * @param sight
	 */
	public void setRange(int sight);
	
	/**
	 * this method set the index of the player
	 * @param retreat
	 */
	public void setIndex(int retreat);
	
	/**
	 * @return the sight
	 */
	public int getSight();
	
	/**
	 * @return the index
	 */
	public int getIndex();
	
	/**
	 * @return the role of the player
	 */
	public Role getRole();
	
	/**
	 * @return the hand of card of the player
	 */
	public List<Card> getCard();
	
	/**
	 * this method is use to add a card in the hand of player
	 * @param card
	 */
	public void addCard(Card card);
	
	/**
	 * this method is use to use a card
	 * @param card
	 */
	public void playCard(Card card);
	
	/**
	 * this method is use to remove a card to the hand of the gamer
	 * @param card
	 */
	public void removeCard(Card card);
	
	
}
