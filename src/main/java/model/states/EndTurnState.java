package model.states;

import model.GameStateMachine;

public class EndTurnState implements State {

    private GameStateMachine gameState;
    
    public EndTurnState(final GameStateMachine gameState) {
        this.gameState = gameState;
    }
    
    @Override
    public void handle() {
        this.gameState.getTable().setCurrentPlayer(this.gameState.getTable().getNextPlayer());
        this.gameState.setCurrentState(new DrawCardsState(this.gameState));
    }

}
