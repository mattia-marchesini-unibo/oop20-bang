package model.states;

import model.GameStateMachine;

public class EndTurnState implements State {

    @Override
    public void handle(final GameStateMachine gsMachine) {
        gsMachine.getTable().nextPlayer();
        gsMachine.setCurrentState(new PlayerStartTurnState());
    }

}
