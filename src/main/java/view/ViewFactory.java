package view;

import model.deck.IDeck;

public interface ViewFactory {
    
    /**
     * @return a view containing the main menu of the game
     */
    View getMenuView();
    
    /**
     * @return a view containing the game rules
     */
    View getRulesView();
    
    /**
     * @param playerNum
     * @param deck
     * @return the main game view
     */
    View getGameView(final int playerNum, final IDeck deck);

}
