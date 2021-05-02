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
        this.currentState.handle(this);
    }

    public ObservableElement<String> getMessageObservable() {
        return this.messageObs;
    }

    public void setMessage(final String message) {
        this.messageObs.set(message);
    }

    public void setCurrentState(final State state) {
        this.currentState = state;
    }

    public Table getTable() {
        return this.table;
    }

    public State getCurrentState() {
        return this.currentState;
    }
}
