package model.states;

import model.GameStateMachine;
import model.Player;
import model.Table;

public class StartTurnState implements State {

    @Override
    public void handle(GameStateMachine gsMachine) {
        Table table = gsMachine.getTable();
        Player current = table.getCurrentPlayer();
        System.out.println(current.getName() + " has prison: " + current.hasPrison());
        
        if(!current.hasPrison()) {
            table.getDeck().nextCards(2).forEach(c -> current.addCard(c));
        } else {
            current.setPrison(false);
//            System.out.println(current.getActiveCardsByName("jail"));
//            current.removeActiveCard(current.getActiveCardsByName("jail").get(0));
            gsMachine.setCurrentState(new EndTurnState());
            gsMachine.go();
        }

        gsMachine.setMessage("startTurn");
    }

}
