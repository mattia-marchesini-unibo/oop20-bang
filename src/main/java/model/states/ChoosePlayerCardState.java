package model.states;

import java.util.List;

import model.GameStateMachine;
import model.Player;
import model.Table;
import model.card.Card;

public class ChoosePlayerCardState implements State {

    @Override
    public void handle(GameStateMachine gsMachine) {
        Table table = gsMachine.getTable();
        Player current = table.getCurrentPlayer();
        var cardObs = table.getChooseCardsObservable();
        cardObs.addObserver(() -> {
            Card c = cardObs.get().keySet().iterator().next();
            gsMachine.setCurrentState(new PlayCardState(c));
        });
        
        table.chooseCards(current.getCards(), List.of(current), 1);
        gsMachine.setMessage("chooseCards");
    }

}
