package model.states;

import model.GameStateMachine;

public interface State {
    
    void handle(final GameStateMachine gsMachine);
}
