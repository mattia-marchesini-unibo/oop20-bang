package view;

import model.deck.IDeck;

public class SwingViewFactory implements ViewFactory {
    
    @Override
    public View getMenuView() {
        return new MenuView();
    }

    @Override
    public View getRulesView() {
        return new RulesView();
    }

    @Override
    public View getGameView(int playerNum, IDeck deck) {
        return new GameView(playerNum, deck);
    }

}
