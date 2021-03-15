package model;

public class GameStateMachine {
    ObservableElement<State> currentState = new ObservableElement<>();
    
    void go() {
        this.currentState.setNotEqual(currentState.get().handle());
    }
    
    void setStartState(State state, boolean notify) {
        if(notify) {
            this.currentState.set(state);
        }
        else {
            this.currentState.setNoNotify(state);
        }
    }

    void addStateChangeObserver(IObserver observer) {
        this.currentState.addObserver(observer);
    }
    
    State getCurrenState() {
        return this.currentState.get();
    }
}
