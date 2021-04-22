package controller;

import view.ViewFactory;

public class GameController implements IViewController {

    private int numberOfPlayers;

    public GameController(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }


    @Override
    public void setup(ViewFactory factory) {
//        v = factory.getGameView();
    }

}
