package model.states;

import model.GameStateMachine;

public class DrawCardsState implements State{

    private static final int N_CARDS = 2;
    private GameStateMachine gameState;
    
    public DrawCardsState(final GameStateMachine gameState) {
        this.gameState = gameState;
    }
    
    @Override
    public void handle() {
        this.gameState.getTable().drawCards(N_CARDS);
        this.gameState.setCurrentState(new ActionsState(this.gameState));
    }

}
