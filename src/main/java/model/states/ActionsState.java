package model.states;

import model.GameStateMachine;

public class ActionsState implements State{

    private GameStateMachine gameState;
    
    public ActionsState(final GameStateMachine gameState) {
        this.gameState = gameState;
    }
    
    @Override
    public void handle() {
        // TODO dovrebbe essere una cosa del genere
        // while(!isOver()) {
        //     this.gameState.getTable().action(action, targets);
        // }
        this.gameState.setCurrentState(new EndTurnState(this.gameState));
    }
    
}
