package model.states;

import libs.observe.ObservableElement;
import model.GameStateMachine;

public class ChooseActionState implements State {

    private ObservableElement<String> observable;
    
    public ChooseActionState(final ObservableElement<String> observable) {
        this.observable = observable;
    }
    
    @Override
    public void handle(GameStateMachine gsMachine) {
        // TODO Auto-generated method stub
        // serve observable<String>
    }

}
