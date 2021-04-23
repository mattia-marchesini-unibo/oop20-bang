package model.states;

import model.GameStateMachine;

public class EndGameState implements State {

    @Override
    public void handle(GameStateMachine gsMachine) {
        gsMachine.setMessage("end");
    }

}
