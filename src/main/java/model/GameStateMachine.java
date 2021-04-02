package model;

import libs.oberve.IObserver;
import libs.oberve.ObservableElement;
import model.states.State;

public class GameStateMachine {
    
    private ObservableElement<State> currentState = new ObservableElement<>();
    private Table table;
    
    public GameStateMachine(final Table table) {
        this.table = table;
    }
    
    public void go() {
        currentState.get().handle();
    }
    
    public void setStartState(final State state, final boolean notify) {
        if(notify) {
            this.currentState.set(state);
        }
        else {
            this.currentState.setNoNotify(state);
        }
    }

    public void addStateChangeObserver(final IObserver observer) {
        this.currentState.addObserver(observer);
    }
    
    public State getCurrentState() {
        return this.currentState.get();
    }
    
    public void setCurrentState(final State state) {
        this.currentState.setNotEqual(state);
    }
    
    public Table getTable() {
        return this.table;
    }
}
