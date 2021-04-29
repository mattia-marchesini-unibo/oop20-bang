package model.states;

import java.util.Map;

import libs.observe.IObserver;

import static java.util.Map.entry;

import java.util.HashMap;

import model.GameStateMachine;
import model.card.Card;

public class ChooseActionState implements State {

    private GameStateMachine gsMachine = null;
    private IObserver observer;

    private Map <String, Runnable> actionMap = new HashMap<String, Runnable>(Map.ofEntries(
        entry("playCard", () -> {
            Card card = gsMachine.getTable().getCurrentPlayer().getCardsByName("indians").get(0);
            gsMachine.setCurrentState(new PlayCardState(card));
        }),
        entry("endTurn", () -> {
            gsMachine.setCurrentState(new EndTurnState());
        }),
        entry("discardCard", () -> {
        })
    ));

    @Override
    public void handle(GameStateMachine gsMachine) {
        this.gsMachine = gsMachine;
        var msgObs = gsMachine.getTurnMessageObservable();
        msgObs.addObserver(() -> {
            System.out.println(msgObs.get());
            if(actionMap.containsKey(msgObs.get())) {
                actionMap.get(msgObs.get()).run();
            }
        });
        msgObs.addObserver(() -> gsMachine.go());
    }

}
