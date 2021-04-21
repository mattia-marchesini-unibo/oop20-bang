package model.states;

import model.GameStateMachine;

public class EndTurnState implements State {

    @Override
    public void handle(GameStateMachine gsMachine) {
        this.gameState.getTable().setCurrentPlayer(this.gameState.getTable().getNextPlayer());
        this.gameState.setCurrentState(new DrawCardsState(this.gameState));
    }

}
