package model.states;

import model.GameStateMachine;
import model.Table;
import model.card.Card;

public class PlayerActionState implements State{

    private Card playCard;

    public PlayerActionState(Card playCard) {
        this.playCard = playCard;
    }

    @Override
    public void handle(final GameStateMachine gsMachine) {
        Table table = gsMachine.getTable();
        
        table.chooseCards(null, null, 0);
        table.getCurrentPlayer().playCard(null, null);
        gsMachine.setCurrentState(new ArePlayersDeadState());
    }
    
}
