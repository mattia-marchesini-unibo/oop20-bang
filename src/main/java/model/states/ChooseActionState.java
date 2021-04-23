package model.states;

import model.GameStateMachine;

public class ChooseActionState implements State {

    @Override
    public void handle(GameStateMachine gsMachine) {
        if (gsMachine.getMessageObservable().get().equals("PlayCard")) {
            gsMachine.setCurrentState(new ChoosePlayerCardState());
        } else if (gsMachine.getMessageObservable().get().equals("EndTurn")){
            gsMachine.setCurrentState(new EndTurnState());
        }
    }

}
