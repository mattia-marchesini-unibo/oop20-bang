package model.states;

import java.util.Map;

import libs.Pair;

import java.util.HashMap;

import model.GameStateMachine;
import model.Table;
import model.Table.Message;
import model.card.Card;
import model.card.Color;

public class PlayCardState implements State {

    private Card playedCard;
    private GameStateMachine gsMachine;

    private Map<Message, Pair<Runnable, String>> tableMsgMap = new HashMap<>(Map.of(
        Message.CHOOSE_CARD, new Pair<>(
            (Runnable)() -> {
                gsMachine.getTable().getChooseCardsObservable().addObserver(() -> {
                    gsMachine.setCurrentState(new CheckDeadPlayersState());
                    gsMachine.go();
                });
            },
            "chooseCard"
        ),
        Message.CHOOSE_PLAYER, new Pair<>(
            (Runnable)() -> {
                gsMachine.getTable().getChoosePlayerObservable().addObserver(() -> {
                    gsMachine.setCurrentState(new CheckDeadPlayersState());
                    gsMachine.go();
                });
            },
            "choosePlayer"
        ),
        Message.CHOOSE_PLAYER_WITH_DISTANCE, new Pair<>(
            (Runnable)() -> {
                gsMachine.getTable().getChoosePlayerObservable().addObserver(() -> {
                    gsMachine.setCurrentState(new CheckDeadPlayersState());
                    gsMachine.go();
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
        playedCard.getEffect().useEffect(table);
        
        Message msg = table.getMessage();
        table.setMessage(null);
        if(playedCard.getColor().equals(Color.BLUE) && !playedCard.getRealName().equals("jail")) {
            table.getCurrentPlayer().addActiveCard(playedCard);
        }
        if(this.tableMsgMap.containsKey(msg)) {
            var pair = this.tableMsgMap.get(msg);
            pair.getX().run();
            table.getCurrentPlayer().removeCard(playedCard);
            gsMachine.setMessage(pair.getY());
        }
        else {
            table.getCurrentPlayer().removeCard(playedCard);
            gsMachine.setMessage("playedCard");
            gsMachine.setCurrentState(new CheckDeadPlayersState());
            gsMachine.go();
        }
    }
}
