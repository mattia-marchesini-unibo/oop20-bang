package view;

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
     * @param playerNum the number of players
     * @return the main game view
     */
    View getGameView(final int playerNum);

}
