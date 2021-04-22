package model.states;

import libs.observe.ObservableElement;
import model.GameStateMachine;

public class ChooseActionState implements State {

    private ObservableElement<String> action;
    
    public ChooseActionState(final ObservableElement<String> action) {
        this.action = action;
    }
    
    @Override
    public void handle(GameStateMachine gsMachine) {
        if (action.get().equals("PlayCard")) {
            gsMachine.setCurrentState(new ChoosePlayerCardState());
        } else if (action.get().equals("EndTurn")){
            gsMachine.setCurrentState(new EndTurnState());
        }
    }

}
