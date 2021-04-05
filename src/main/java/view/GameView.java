package view;

import model.deck.IDeck;

public class GameView extends AbstractView implements View {
    
    private int playerNum;
    private IDeck deck;
    
    public GameView(final int playerNum, final IDeck deck) {
        this.playerNum = playerNum;
        this.deck = deck;
        
        //TODO
    }

}
