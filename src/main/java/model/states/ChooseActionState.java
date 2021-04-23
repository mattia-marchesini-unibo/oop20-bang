package model.states;

import model.GameStateMachine;

public class ChooseActionState implements State {

    @Override
    public void handle(GameStateMachine gsMachine) {
        var msgObs = gsMachine.getMessageObservable();
        msgObs.addObserver(() -> {
            if (msgObs.get().equals("playCard")) {
                gsMachine.setCurrentState(new ChoosePlayerCardState());
            } else if (msgObs.get().equals("endTurn")){
                gsMachine.setCurrentState(new EndTurnState());
            }
        });
    }

}
