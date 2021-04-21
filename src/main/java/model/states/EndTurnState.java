package model.states;

import model.GameStateMachine;

public class EndTurnState implements State {

    @Override
    public void handle(GameStateMachine gsMachine) {
        gsMachine.getTable().setCurrentPlayer(gsMachine.getTable().getNextPlayer());
        gsMachine.setCurrentState(new PlayerStartTurnState());
    }

}
