package model.states;

import java.util.Map;

import libs.Pair;
import libs.observe.IObserver;

import static java.util.Map.entry;

import java.util.HashMap;

import model.GameStateMachine;
import model.Table;
import model.Table.Message;
import model.card.Card;

public class PlayCardState implements State {

    private Card playedCard;
    private GameStateMachine gsMachine;

    private Map<Message, Pair<Runnable, String>> tableMsgMap = new HashMap<>(Map.of(
        Message.CHOOSE_CARD, new Pair<>(
            (Runnable)() -> {
                gsMachine.getTable().getChooseCardsObservable().addObserver(() -> {
                    gsMachine.setCurrentState(new CheckDeadPlayersState());
                });
            },
            "chooseCard"
        ),
        Message.CHOOSE_PLAYER, new Pair<>(
            (Runnable)() -> {
                gsMachine.getTable().getChoosePlayersObservable().addObserver(() -> {
                    gsMachine.setCurrentState(new CheckDeadPlayersState());
                });
            },
            "choosePlayer"
        ),
        Message.CHOOSE_PLAYER_WITH_DISTANCE, new Pair<>(
            (Runnable)() -> {
                gsMachine.getTable().getChoosePlayersObservable().addObserver(() -> {
                    gsMachine.setCurrentState(new CheckDeadPlayersState());
                });
            },
            "choosePlayerDistance"
        )
    ));

    public PlayCardState(Card playedCard) {
        this.playedCard = playedCard;
    }

    @Override
    public void handle(final GameStateMachine gsMachine) {
        this.gsMachine = gsMachine;
        Table table = gsMachine.getTable();
        table.getCurrentPlayer().removeCard(playedCard);
        playedCard.getEffect().useEffect(table);
        Message msg = table.getMessage();
        if(this.tableMsgMap.containsKey(msg)) {
            var pair = this.tableMsgMap.get(msg);
            pair.getX().run();
            gsMachine.setMessage(pair.getY());
            gsMachine.go();
        }
        else {
//            gsMachine.setMessage(null);
            gsMachine.setCurrentState(new CheckDeadPlayersState());
            gsMachine.go();
        }
    }
}
