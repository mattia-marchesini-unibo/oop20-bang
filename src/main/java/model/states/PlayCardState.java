package model.states;

import model.GameStateMachine;
import model.Table;
import model.card.Card;

public class PlayCardState implements State {

    Card playedCard;

    public PlayCardState(Card playedCard) {
        this.playedCard = playedCard;
    }

    @Override
    public void handle(final GameStateMachine gsMachine) {
        Table table = gsMachine.getTable();
        table.getCurrentPlayer().removeCard(playedCard);
        playedCard.getEffect().useEffect(table);

        // if table message ==
    }
}
