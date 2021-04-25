package model;

import libs.observe.ObservableElement;
import model.states.State;

public class GameStateMachine {
    
    private State currentState;
    private Table table;
    private ObservableElement<String> messageObs = new ObservableElement<>();
    
    public GameStateMachine(final Table table) {
        this.table = table;
    }
    
    public void go() {
        currentState.handle(this);
    }
    
    public void setStartState(final State state) {
            this.currentState = state;
    }

    public ObservableElement<String> getMessageObservable() {
        return this.messageObs;
    }
    
    public void setMessage(final String message) {
        this.messageObs.set(message);
    }
    
    public State getCurrentState() {
        return this.currentState;
    }
    
    public void setCurrentState(final State state) {
        this.currentState = state;
    }
    
    public Table getTable() {
        return this.table;
    }
}
