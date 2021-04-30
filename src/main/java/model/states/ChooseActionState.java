package model.states;

import java.util.Map;

import static java.util.Map.entry;

import java.util.HashMap;

import model.GameStateMachine;
import model.card.Card;

public class ChooseActionState implements State {
    
    private GameStateMachine gsMachine = null;
    private final String action;
    private Map <String, Runnable> actionMap = new HashMap<String, Runnable>(Map.ofEntries(
            entry("playCard", () -> {
                Card card = gsMachine.getTable().getCurrentPlayer().getCardsByName("indians").get(0);
                gsMachine.setCurrentState(new PlayCardState(card));
                gsMachine.go();
            }),
            entry("endTurn", () -> {
                gsMachine.setCurrentState(new EndTurnState());
                gsMachine.go();
            }),
            entry("discardCard", () -> {
                gsMachine.setMessage("discardCard");
            })
        ));
    
    public ChooseActionState(final String action) {
        this.action = action;
    }

    @Override
    public void handle(GameStateMachine gsMachine) {
        System.out.println("ChooseActionState");
        this.gsMachine = gsMachine;
        
        if(actionMap.containsKey(action)) {
            this.actionMap.get(action).run();
        }
    }

}
